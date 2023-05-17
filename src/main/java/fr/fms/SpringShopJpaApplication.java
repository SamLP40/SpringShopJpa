package fr.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}

@Override
public void run(String...args) throws Exception { // création des articles
//	categoryRepository.save(new Category("Smartphone"));
//	articleRepository.save(new Article("8", "Samsung", 250));
//	articleRepository.save(new Article("S8", "Samsung", 200));
//	articleRepository.save(new Article("S9", "Samsung", 250));
//	articleRepository.save(new Article("14", "Iphone", 1250));
//	articleRepository.save(new Article("20", "Iphone", 50000));
//	articleRepository.save(new Article("10", "Iphone", 999));
//	articleRepository.save(new Article("5", "Iphone", 665));
//	articleRepository.save(new Article("3310", "Nokia", 2));

	//boucle qui va parcourir les articles et trier par prix/marque
	for(Article article : articleRepository.findByBrandAndPrice("Samsung", 250)) {
		System.out.println(article);
	}
	for (Article article : articleRepository.findByBrandAndPriceGreaterThan("Samsung", 200)) {
		System.out.println(article);
	}

}
}
