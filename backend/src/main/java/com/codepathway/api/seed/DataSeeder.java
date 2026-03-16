package com.codepathway.api.seed;

import com.codepathway.api.entity.Category;
import com.codepathway.api.entity.Role;
import com.codepathway.api.entity.Sheet;
import com.codepathway.api.entity.Topic;
import com.codepathway.api.repository.CategoryRepository;
import com.codepathway.api.repository.RoleRepository;
import com.codepathway.api.repository.SheetRepository;
import com.codepathway.api.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final CategoryRepository categoryRepository;
    private final SheetRepository sheetRepository;
    private final TopicRepository topicRepository;

    public DataSeeder(RoleRepository roleRepository, CategoryRepository categoryRepository, SheetRepository sheetRepository, TopicRepository topicRepository) {
        this.roleRepository = roleRepository;
        this.categoryRepository = categoryRepository;
        this.sheetRepository = sheetRepository;
        this.topicRepository = topicRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role("ROLE_USER"));
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (categoryRepository.count() == 0) {
            Category dsa = new Category("DSA Sheets", "Structured coding interview sheets", "dsa-sheets");
            Category cs = new Category("Core CS", "CS fundamentals and interview topics", "core-cs");
            categoryRepository.save(dsa);
            categoryRepository.save(cs);

            Sheet a2z = new Sheet("A2Z DSA Sheet", "a2z-dsa-sheet", "Complete A2Z DSA curriculum", "Intermediate", false);
            a2z.setCategory(dsa);
            Sheet blind75 = new Sheet("Blind 75", "blind-75", "High yield coding problems", "Intermediate", false);
            blind75.setCategory(dsa);
            Sheet dbms = new Sheet("DBMS Sheet", "dbms-sheet", "DBMS topic-by-topic guide", "Easy", false);
            dbms.setCategory(cs);
            sheetRepository.save(a2z);
            sheetRepository.save(blind75);
            sheetRepository.save(dbms);

            topicRepository.save(new Topic("Array Basics", "array-basics", "Introduction to arrays.", "Easy", 1));
            topicRepository.save(new Topic("Graph BFS/DFS", "graph-bfs-dfs", "Graph traversal methods.", "Medium", 2));
        }
    }
}
