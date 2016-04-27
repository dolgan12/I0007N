package com.garpo.i0007n.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public interface PersonDAO {
    int addPerson(Person person) throws Exception;

    Person getPerson(int id) throws Exception;

    List<Person> getAllPersons() throws Exception;

    int updatePerson(Person person) throws Exception;

    int deletePerson(int id) throws Exception;

    int deleteAll() throws Exception;

    List<SkillCategory> getPersonSkills(int id) throws Exception;
}
