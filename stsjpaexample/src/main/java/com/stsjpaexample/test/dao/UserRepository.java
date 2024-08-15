package com.stsjpaexample.test.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stsjpaexample.test.entities.Userdata;

public interface UserRepository extends  CrudRepository<Userdata,Integer> {


	public List<Userdata> findByCity(String city);
	
	public List<Userdata> findByName(String Name);
	
	public List<Userdata> findByUserIdGreaterThanEqual(int userId);
	
	public List<Userdata> findByUserIdLessThan(int userId);
	
	public List<Userdata> findByNameLike(String likepattern);
	
	public List<Userdata> findByNameIn(Collection<String> namevalues );
	
	public List<Userdata> findByNameInOrderByUserId(Collection<String> namevalues );
	
	@Query("select i from Userdata i")
	public List<Userdata> getAllUser();
	
	@Query("select i from Userdata i WHERE name =:u AND city =:o ")
	public List<Userdata> getUserByNameANDCity(@Param("u")String name, @Param("o")String city);
	
	@Query(value = "select * from userdata", nativeQuery = true)
	public List<Userdata> getuserdetails();
	
	
	
}
