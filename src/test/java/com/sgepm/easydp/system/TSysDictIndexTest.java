package com.sgepm.easydp.system;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sgepm.easydp.system.entity.SysDictGroup;
import com.sgepm.easydp.system.manager.SysDictGroupManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TSysDictIndexTest {
	
	@Autowired
	private SysDictGroupManager sysDictIndexManager;
	
	@Test
	public void test1() {
		List<SysDictGroup> sysDictIndexList = sysDictIndexManager.findBeanList("select * from sys_dict_group");
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		System.out.println(sysDictIndexList.get(0).getCode());
	}
	
}
