package com.stsjpaexample.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.stsjpaexample.test.dao.UserRepository;
import com.stsjpaexample.test.entities.Userdata;

@SpringBootApplication
public class StsjpaexampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(StsjpaexampleApplication.class, args);
		
		UserRepository UserRepository = context.getBean(UserRepository.class);
		/*
		Userdata user = new Userdata();
		Userdata user1 = new Userdata();
		user.setName("BhavinKumar Kothari");
		user.setCity("Airoli");
		user.setStatus("Learning Spring boot application with jpa");
		
		user1.setStatus("React js");
		user1.setName("Amar");
		user1.setCity("Thane");
		//below is used for saving single objects
		//Userdata user1 = UserRepository.save(user);
		
		List<Userdata> userlist = List.of(user,user1);
		
		// below is used for saving multiple objects
		Iterable<Userdata> itr_result = UserRepository.saveAll(userlist);
		
		itr_result.forEach(singleuser -> 
		{
			
		System.out.println("User Info"+singleuser);
		
		});
		System.out.println("done");
	*/
		
		// for updating data into the database
		/*
		 Optional<Userdata> optional = UserRepository.findById(2);
		 
		 Userdata use = optional.get();
		 
		 use.setName("Tushar");
		 use.setCity("Bangalore");
		 use.setStatus("ETL developer");
		 
		 
		 Userdata resultreturned =	 UserRepository.save(use);
		 System.out.println("user updated "+ resultreturned);
		 
		 */
		
		
		// how to read/get data from db
		
		
	
	//Iterable <Userdata> itr_return = UserRepository.findByCity("Airoli");
	//Iterable <Userdata> itr_return1 = UserRepository.findByName("Tushar");
	
		//Iterable <Userdata> itr_return1 = UserRepository.findByUserIdGreaterThanEqual(1);
		
	//UserRepository.findByName("Bhavin");
	/*
	Iterator<Userdata>  iterator = itr_return.iterator();
	while(iterator.hasNext())
	{
		Userdata Userdata = iterator.next();
		System.out.println("using iterator and while loop"+Userdata);
	}
	*/
	//itr_return.forEach(userr -> System.out.println("return infor "+userr));
	//itr_return1.forEach(userr1 -> System.out.println("return infor "+userr1));
	
	// deleting the element from fb
		
		
		//UserRepository.deleteById(3);
		
		//System.out.println("deleted successfully");
		
		
		List<Userdata> alluser = UserRepository.getAllUser();
		alluser.forEach(e -> System.out.println(e));
		
		
		
		System.out.println("__________________________________");
		
		
		List<Userdata> searchbynamecity = UserRepository.getUserByNameANDCity("Tushar", "Bangalore");
		searchbynamecity.forEach(o -> System.out.println(o));
		
		
		System.out.println("Native Query results fetched below________________");
		
		 UserRepository.getuserdetails().forEach(q -> System.out.println(q));
		
		
		
		
		
		
	

	
		
		
		
		
		
		 
		
		
		
		
	}

}
