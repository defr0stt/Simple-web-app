package ua.lpnu.repo;

import org.springframework.data.repository.CrudRepository;
import ua.lpnu.models.Post;

// створення інтерфейсу для дій з бд
// наслідується від CrudRepository так, як
// він має базові функції для роботи
// <модель, з якою працюю ; тип ключа>
public interface PostRepository extends CrudRepository<Post, Long>
{

}