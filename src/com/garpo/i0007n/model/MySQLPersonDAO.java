package com.garpo.i0007n.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conny Garpö on 4/23/2016.
 */
public class MySQLPersonDAO implements PersonDAO{

    @Override
    public int addPerson(Person person) throws Exception {
        String sql = "INSERT INTO personal (id, fName, eName) values (?,?,?)";
        Connection conn = MySQLDatabase.getInstance().getConnection();

        PreparedStatement p = conn.prepareStatement(sql);

        p.setInt(1, person.getId());
        p.setString(2, person.getFname());
        p.setString(3, person.getEname());

        int added = p.executeUpdate();

        if(added > 0){
            List<SkillCategory> skills = person.getSkills();
            int personId = person.getId();
            String skillSql = "INSERT INTO PersonalCategory (personalId, categoryId, categoryDesciption) values (?,?,?)";
            PreparedStatement skillUpdate = conn.prepareStatement(skillSql);

            for(SkillCategory skill : skills){

                skillUpdate.setInt(1, personId);
                skillUpdate.setInt(2, skill.getId());
                skillUpdate.setString(3, skill.getDescription());

                added += skillUpdate.executeUpdate();
            }
        }
        p.close();

        return added;
    }

    @Override
    public Person getPerson(int id) throws Exception{

        String selectSQL = "SELECT * FROM personal WHERE id = ?";
        Connection con = MySQLDatabase.getInstance().getConnection();
        PreparedStatement selectStatement = con.prepareStatement(selectSQL);
        selectStatement.setInt(1, id);

        ResultSet resultSet = selectStatement.executeQuery();
        resultSet.next();
        int personId = resultSet.getInt("id");
        String fname = resultSet.getString("fName");
        String ename = resultSet.getString("eName");

        List<SkillCategory> skills = getPersonSkills(personId);

        Person person = new Person(personId, fname, ename, skills);

        resultSet.close();
        selectStatement.close();
        return person;
    }

    @Override
    public List<Person> getAllPersons() throws Exception {
        List<Person> persons = new ArrayList<>();
        String selectSQL = "SELECT id, fName, eName from personal ORDER BY id";
        Connection conn = MySQLDatabase.getInstance().getConnection();

        Statement selectStatement = conn.createStatement();
        ResultSet resultSet = selectStatement.executeQuery(selectSQL);
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String fname = resultSet.getString("fName");
            String ename = resultSet.getString("eName");
            List<SkillCategory> skills = getPersonSkills(id);
            Person person = new Person(id, fname, ename, skills);
            persons.add(person);
        }
        resultSet.close();
        selectStatement.close();
        return persons;
    }

    @Override
    public int updatePerson(Person person) throws Exception {
        return 0;
    }

    @Override
    public int deletePerson(int id) throws Exception {
        return 0;
    }

    @Override
    public int deleteAll() throws SQLException {
        return 0;
    }

    @Override
    public List<SkillCategory> getPersonSkills(int personId) throws Exception{
        List<SkillCategory> skills = new ArrayList<>();
        String sql = "SELECT categoryId, categoryDesciption FROM PersonalCategory WHERE personalId = ?";
        Connection con = MySQLDatabase.getInstance().getConnection();

        PreparedStatement selectStatement = con.prepareStatement(sql);
        selectStatement.setInt(1, personId);

        ResultSet resultSet = selectStatement.executeQuery();

        while (resultSet.next()){
            int catId = resultSet.getInt("categoryId");
            String catDescription = resultSet.getString("categoryDesciption");

            SkillCategory skill = new SkillCategory(catId,catDescription);
            skills.add(skill);
        }

        resultSet.close();
        selectStatement.close();
        return skills;
    }
}
