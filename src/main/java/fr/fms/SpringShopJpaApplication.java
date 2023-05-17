package fr.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {
// private static Long ID = null;
@Autowired
private CategoryRepository categoryRepository;
@Autowired
private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}

@Override
public void run(String...args) throws Exception { // création des articles
//	categoryRepository.save(new Category("Smartphone", Phone));
	Category phone = categoryRepository.save(new Category("Phone"));
	Category iphone = categoryRepository.save(new Category("Iphone"));
	Category garbage = categoryRepository.save(new Category("Garbage"));
	articleRepository.save(new Article("8", "Samsung", 250, phone));
	articleRepository.save(new Article("S8", "Samsung", 200, phone));
	articleRepository.save(new Article("S9", "Samsung", 250, phone));
	articleRepository.save(new Article("14", "Iphone", 1250, iphone));
	articleRepository.save(new Article("20", "Iphone", 50000, iphone));
	articleRepository.save(new Article("10", "Iphone", 999, iphone));
	articleRepository.save(new Article("5", "Iphone", 665, iphone));
	articleRepository.save(new Article("3310", "Nokia", 2, garbage));

	//boucle qui va parcourir les articles et trier par prix/marque
	for(Article article : articleRepository.findByBrandAndPrice("Samsung", 250)) {
		System.out.println(article);
	}
	// boucle qui va rechercher tous les articles dont le prix est supérieur à 200 (et de marque Samsung)
	for (Article article : articleRepository.findByBrandAndPriceGreaterThan("Samsung", 200)) {
		System.out.println(article);
	}
	// boucle qui recherche par mot clé : la recherche doit comprendre le terme "sung" et le prix doit valoir 200
	for (Article article : articleRepository.searchArticles("sung", 200)) {
	System.out.println(article); //équivalent = findByKeyword
	}

	// articleRepository.deleteById((long) 1);
	Hibernate.initialize(articleRepository.getById((long) 3));
	articleRepository.save(new Article("T92", "Motorola", 0, garbage));
}

}

/* 1.2) 1er moyen : select [Nom article] from article;
 * 2e moyen : for(Article article : articleRepository.findArticleById(id, desc, price, Category) { system.out.println(article)}
 * 
 * 1.3) public List<Article> findByDescriptionAndBrand(String description, String brand); 
 * 
 * 1.4) Il suffit de faire drop database article et le tour est joué
 * 
 * Vraie méthode : public void deleteById(Long id);
 * Dans l'appli : articleRepository.deleteById((long) id);
 * 
 * Il faut caster de int à long, car l'id n'est pas un int.
 * 
 * 1.5) 
*/
