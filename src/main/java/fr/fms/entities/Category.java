package fr.fms.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private Collection<Article> articles; // Une catégorie est liée à plusieurs articles.
	
	public Category(String name) {
		this.name=name;
	}

	public Category() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) { 
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Article> getArticles() {
		return articles;
	}

	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}

	public Category(Long id, String name, Collection<Article> articles) {
		this.id = id;
		this.name = name;
		this.articles = articles;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}