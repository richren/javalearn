import demoJPA.dao.CategoryRepository;
import demoJPA.entity.Category;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class testJpa {

    int id = 1;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test1Save() {
        Category category = new Category();
        category.setId(id);
        category.setName("test");
        categoryRepository.save(category);
    }

    @Test
    public void test2UpdateName() {
        String name = "test111";
        categoryRepository.updateName(id, name);
    }

    @Test
    public void test3FindById() {
        Category category = categoryRepository.findOne(id);
        System.out.println(category);
    }

    @Test
    public void test4count() {
        long count = categoryRepository.count();
        System.out.println(count);
    }

    @Test
    public void test5FindAll() {
        Iterable<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Test
    public void test6Delete() {
        categoryRepository.delete(id);
    }

}
