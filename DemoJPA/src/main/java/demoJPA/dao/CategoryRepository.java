package demoJPA.dao;

import demoJPA.entity.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryRepository extends Repository<Category, Integer> {
    void save(Category category);

    Iterable<Category> findAll();

    long count();

    void delete(int id);

    @Query("from Category where id=:id")
    Category findOne(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("update Category  set name=:name where id=:id")
    void updateName(@Param("id") int id, @Param("name") String name);
}
