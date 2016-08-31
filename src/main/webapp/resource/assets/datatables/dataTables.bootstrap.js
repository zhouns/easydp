/*! DataTables Bootstrap 3 integration
 * ©2011-2014 SpryMedia Ltd - datatables.net/license
 */

/**
 * DataTables integration for Bootstrap 3. This requires Bootstrap 3 and
 * DataTables 1.10 or newer.
 * 
 * This file sets the defaults and adds options to DataTables to style its
 * controls using Bootstrap. See http://datatables.net/manual/styling/bootstrap
 * for further information.
 */
(function(window, document, undefined) {

	var factory = function($, DataTable) {
		"use strict";

		/* Set the defaults for DataTables initialisation */
		$.extend(true, DataTable.defaults, {
			dom : "<'row'<'col-sm-6'l><'col-sm-6'f>>"
					+ "<'row'<'col-sm-12'tr>>"
					+ "<'row'<'col-sm-6'i><'col-sm-6'p>>",
			renderer : 'bootstrap',
			ordering: false,
			filter: false,
		 	dom: 'rtlip',
	        language: {
	            lengthMenu: '_MENU_',
	            processing: '<i class="fa fa-refresh fa-spin"></i> 正在加载数据...',
	            zeroRecords: '没有检索到数据',
	            emptyTable: '没有可用的数据',
	            info: '<font class="text-primary">_PAGE_</font>/<font class="text-primary">_PAGES_</font>	第<font class="text-primary"> _START_ </font>到<font class="text-primary"> _END_ </font>条, 共<font class="text-primary"> _TOTAL_ </font>条',
	           	infoFiltered: ',共<font class="text-primary"> _MAX_ </font>记录',
	            oPaginate: {
	                sFirst: '首页',
	                sPrevious: '上一页',
	                sNext: '下一页',
	                sLast: '尾页'
	            }
	        }
		});

		/* Default class modification */
		$.extend(DataTable.ext.classes, {
			sWrapper : "dataTables_wrapper form-inline dt-bootstrap",
			sFilterInput : "form-control input-sm",
			sLengthSelect : "form-control input-sm"
		});

		/* Bootstrap paging button renderer */
		DataTable.ext.renderer.pageButton.bootstrap = function(settings, host,
				idx, buttons, page, pages) {
			var api = new DataTable.Api(settings);
			var classes = settings.oClasses;
			var lang = settings.oLanguage.oPaginate;
			var btnDisplay, btnClass;

			var attach = function(container, buttons) {
				var i, ien, node, button;
				var clickHandler = function(e) {
					e.preventDefault();
					if (!$(e.currentTarget).hasClass('disabled')) {
						api.page(e.data.action).draw(false);
					}
				};

				for (i = 0, ien = buttons.length; i < ien; i++) {
					button = buttons[i];

					if ($.isArray(button)) {
						attach(container, button);
					} else {
						btnDisplay = '';
						btnClass = '';

						switch (button) {
						case 'ellipsis':
							btnDisplay = '&hellip;';
							btnClass = 'disabled';
							break;

						case 'first':
							btnDisplay = lang.sFirst;
							btnClass = button + (page > 0 ? '' : ' disabled');
							break;

						case 'previous':
							btnDisplay = lang.sPrevious;
							btnClass = button + (page > 0 ? '' : ' disabled');
							break;

						case 'next':
							btnDisplay = lang.sNext;
							btnClass = button
									+ (page < pages - 1 ? '' : ' disabled');
							break;

						case 'last':
							btnDisplay = lang.sLast;
							btnClass = button
									+ (page < pages - 1 ? '' : ' disabled');
							break;

						default:
							btnDisplay = button + 1;
							btnClass = page === button ? 'active' : '';
							break;
						}

						if (btnDisplay) {
							node = $(
									'<li>',
									{
										'class' : classes.sPageButton + ' '
												+ btnClass,
										'aria-controls' : settings.sTableId,
										'tabindex' : settings.iTabIndex,
										'id' : idx === 0
												&& typeof button === 'string' ? settings.sTableId
												+ '_' + button
												: null
									}).append($('<a>', {
								'href' : '#'
							}).html(btnDisplay)).appendTo(container);

							settings.oApi._fnBindAction(node, {
								action : button
							}, clickHandler);
						}
					}
				}
			};

			attach($(host).empty().html('<ul class="pagination"/>').children(
					'ul'), buttons);
		};

		/*
		 * TableTools Bootstrap compatibility Required TableTools 2.1+
		 */
		if (DataTable.TableTools) {
			// Set the classes that TableTools uses to something suitable for
			// Bootstrap
			$.extend(true, DataTable.TableTools.classes, {
				"container" : "DTTT btn-group",
				"buttons" : {
					"normal" : "btn btn-default",
					"disabled" : "disabled"
				},
				"collection" : {
					"container" : "DTTT_dropdown dropdown-menu",
					"buttons" : {
						"normal" : "",
						"disabled" : "disabled"
					}
				},
				"print" : {
					"info" : "DTTT_print_info"
				},
				"select" : {
					"row" : "active"
				}
			});

			// Have the collection use a bootstrap compatible drop down
			$.extend(true, DataTable.TableTools.DEFAULTS.oTags, {
				"collection" : {
					"container" : "ul",
					"button" : "li",
					"liner" : "a"
				}
			});
		}

	}; // /factory

	// Define as an AMD module if possible
	if (typeof define === 'function' && define.amd) {
		define([ 'jquery', 'datatables' ], factory);
	} else if (typeof exports === 'object') {
		// Node/CommonJS
		factory(require('jquery'), require('datatables'));
	} else if (jQuery) {
		// Otherwise simply initialise as normal, stopping multiple evaluation
		factory(jQuery, jQuery.fn.dataTable);
	}

})(window, document);
