package fr.fms.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// Requêtes HQL (hibernate query language) utilisables au niveau de l'appli
import org.springframework.data.repository.query.Param;

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
		@Query("select A from Article A where A.brand like %:x% and A.price > :y")
		public List<Article> searchArticles(@Param("x") String keyword, @Param("y")double price);
		// Traduction en HQL d'une requête SQL complexe (requête permettant de rechercher par mots clés) 
		public List<Article> findByCategoryId(Long categoryId);
		// Permet d'obtenir tous les articles d'une catégorie
		public List<Article> findByDescriptionAndPrice(String description, String brand);
		// Supprime un article via son ID
		public void deleteById(Long id);
		// Modifie un article via son ID
		public Article getById(Long id);
		// Trie par ordre croissant/décroissant (équivalent de Order by ... ASC/DESC)
		//public Article orderByName(String name);
		//public void updateArticle(long id, String name, String description, double price);
		//void update(java.lang.String article, java.lang.Object object);
	}

