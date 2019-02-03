package am.aca.quiz.software.service.implementations;

import am.aca.quiz.software.entity.CategoryEntity;
import am.aca.quiz.software.entity.SubCategoryEntity;
import am.aca.quiz.software.repository.SubCategoryRepository;
import am.aca.quiz.software.service.interfaces.SubCategoryService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class SubCategoryServiceImp implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryServiceImp categoryServiceImp;

    public SubCategoryServiceImp(SubCategoryRepository subCategoryRepository, CategoryServiceImp categoryServiceImp) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryServiceImp = categoryServiceImp;
    }


    public CategoryServiceImp getCategoryServiceImp() {
        return categoryServiceImp;
    }

    public void addSubCategory(String typename, Long categoryId) throws SQLException {
        CategoryEntity categoryEntity = categoryServiceImp.getById(categoryId);
        if (categoryEntity != null) {
            if (subCategoryRepository.findSubCategoryEntitiesByTypeName(typename) == null) {
                SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
                subCategoryEntity.setTypeName(typename);
                subCategoryEntity.setCategory(categoryEntity);
                categoryEntity.getSubCategoryEntityLists().add(subCategoryEntity);
                subCategoryRepository.saveAndFlush(subCategoryEntity);
            } else {
                throw new SQLException("subCategory is exist");
            }
        }
    }

    public List<SubCategoryEntity> getAll() throws SQLException {
        List<SubCategoryEntity> subCategoryList = subCategoryRepository.findAll();

        if (subCategoryList != null) {
            return subCategoryList;
        } else {
            throw new SQLException("SubCategory table is empty");
        }
    }

    public void update(SubCategoryEntity updatedSubCategory, SubCategoryEntity subCategory) throws SQLException {
        updatedSubCategory.setId(subCategory.getId());
        updatedSubCategory.setCategory(subCategory.getCategory());
        subCategoryRepository.saveAndFlush(updatedSubCategory);
    }

    @Override
    public SubCategoryEntity getById(Long id) throws SQLException {
        Optional<SubCategoryEntity> subCategoryEntity = subCategoryRepository.findById(id);
        if (!subCategoryEntity.isPresent()) {
            throw new SQLException("Entity not found");
        }
        return subCategoryEntity.get();
    }

    public void removeById(Long id) throws SQLException {
        SubCategoryEntity targetEntity = getById(id);
        remove(targetEntity);
    }

    @Override
    public void remove(SubCategoryEntity subCategoryEntity) throws SQLException {
        if (subCategoryEntity != null) {
            subCategoryRepository.delete(subCategoryEntity);
        }
    }

    public SubCategoryEntity getByTypeName(String type) throws SQLException {
        SubCategoryEntity targetEntity = subCategoryRepository.findSubCategoryEntitiesByTypeName(type);
        if (targetEntity != null) {
            return targetEntity;
        } else {
            throw new SQLException("entity not found");
        }
    }

    public Long getCategoryIdBySubCategoryTypeName(String typeName) {
        return subCategoryRepository.findCategoryIdBySubCategoryTypeName(typeName);
    }


    public void update(SubCategoryEntity updatedSubCategoryEntity) {
        subCategoryRepository.save(updatedSubCategoryEntity);
    }
}
