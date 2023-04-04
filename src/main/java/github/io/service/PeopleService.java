package github.io.service;

import github.io.dao.PeopleRepository;
import github.io.model.People;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PeopleService {


    @Resource
    private PeopleRepository repository;

    /**
     * 具体注解使用可以参考这篇文章
     * <a href="https://blog.csdn.net/qq_44936392/article/details/121476927?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522168057222716800215090670%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=168057222716800215090670&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-121476927-null-null.142^v81^insert_down38,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=%20%20%40Cacheable%28%29&spm=1018.2226.3001.4187"> @Cacheable()注解使用 </a>
     */
    @Cacheable(value = "user", key = "#name", unless = "#result eq null")
    public People findByName(String name) {     //查询用户
        return repository.findByName(name);
    }

    @CachePut(value = "user", key = "#result.name", unless = "#result eq null")
    public People savePeople(People people) {   //保存用户
        return repository.save(people);
    }

    @CacheEvict(value = "user", key = "#people.name")
    public void removePeople(People people) {   //删除用户
        repository.delete(people);
    }


}
