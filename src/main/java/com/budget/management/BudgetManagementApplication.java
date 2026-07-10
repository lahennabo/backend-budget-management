package com.budget.management;

import com.budget.management.entity.Category;
import com.budget.management.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = "com.budget.management.entity")
public class BudgetManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetManagementApplication.class, args);
        System.out.println(">>> Budget-Management-Application FIN DE COMPILATION >>>>>>");
    }

    @Bean
    public CommandLineRunner dataLoader(CategoryRepository categoryRepository) {
        return args -> {
            // Création de la première catégorie
            Category cat1 = new Category();
            cat1.setName("Électronique");
            cat1.setDescription("Smartphones, ordinateurs et accessoires");
            cat1.setColor(":color:");
            categoryRepository.save(cat1);

            // Création de la deuxième catégorie
            Category cat2 = new Category();
            cat2.setName("Livres");
            cat2.setDescription("Romans, sciences et bandes dessinées");
            cat2.setColor(":color:");
            categoryRepository.save(cat2);

            System.out.println(">>> Données de test insérées avec succès ! >>>");
        };
    }
}
