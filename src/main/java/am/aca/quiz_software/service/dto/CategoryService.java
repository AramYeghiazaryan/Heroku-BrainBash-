package am.aca.quiz_software.service.dto;

<<<<<<< HEAD
import am.aca.quiz_software.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface CategoryService {
    //create
    void addCategory(CategoryEntity category) throws SQLException;

    //read
    List<CategoryEntity> getAll() throws SQLException;

    //update
    void update(CategoryEntity category) throws SQLException;

    //delete
    void remove(CategoryEntity category) throws SQLException;
=======
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    //TODO methods and constructor
>>>>>>> dfa5e88c635184eb52a4efb6a23550b85acf9daa
}