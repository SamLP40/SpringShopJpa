package fr.fms.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// Requêtes HQL (hibernate query language) utilisables au niveau de l'appli

import fr.fms.entities.Article;

	public interface ArticleRepository extends JpaRepository<Article, Long> {
		public List<Article> findByBrand(String brand); 
		/* Méthode équivalante à la requête SQL select * from ... where ...=... */
		public List<Article> findByBrandContains(String brand);
		/* Méthode similaire à la requête "select * from ... where ... like '%%' */
		public List<Article> findByBrandAndPrice(String brand, double price);
		/* Méthode qui va chercher la marque et le prix en base, pour établir une requête
		 * select * from ... where ... and ...=...;*/
		public List<Article> findByBrandAndPriceGreaterThan(String brand, double price);
		//Méthode qui va retourner les articles dont le prix est supérieur à ...

		
	}
	

