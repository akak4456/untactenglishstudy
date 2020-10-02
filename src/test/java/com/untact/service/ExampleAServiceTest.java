package com.untact.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.untact.demo.UntactenglishstudyApplication;
import com.untact.domain.ExampleA;
import com.untact.domain.ExampleASpecial1;
import com.untact.domain.ExampleASpecial2;
import com.untact.persistent.ExampleARepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UntactenglishstudyApplication.class)
@Transactional
@Commit
@Log
public class ExampleAServiceTest {
	@Autowired
	private ExampleAService<ExampleA> service1;
	@Autowired
	private ExampleAService<ExampleASpecial1> service2;
	@Autowired
	private ExampleARepository repo;
	@Before
	public void setUp() {
		repo.deleteAllInBatch();
	}
	@Test
	public void test() {
		ExampleASpecial1 aspecial1_1 = ExampleASpecial1.builder().common("common_1").special1("aspecial1_1").build();
		ExampleASpecial1 aspecial1_2 = ExampleASpecial1.builder().common("common_2").special1("aspecial1_2").build();
		ExampleASpecial2 aspecial2_1 = ExampleASpecial2.builder().common("common_1").special2("aspecial2_1").build();
		ExampleASpecial2 aspecial2_2 = ExampleASpecial2.builder().common("common_2").special2("aspecial2_2").build();
		repo.save(aspecial1_1);
		repo.save(aspecial1_2);
		repo.save(aspecial2_1);
		repo.save(aspecial2_2);
		List<ExampleA> list1 = (List<ExampleA>) service1.getList();
		List<ExampleASpecial1> list2 = (List<ExampleASpecial1>) service2.getList();
		assertEquals(list1.size(),4);
		assertEquals(list2.size(),2);
	}
}