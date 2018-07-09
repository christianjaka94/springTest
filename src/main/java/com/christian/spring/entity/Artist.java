package com.christian.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="ARTIST")
public class Artist {

	@Id
	@Column(name="artist_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private int year;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Artist_Style", 
        joinColumns = { @JoinColumn(name = "style_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "artist_id") }
    )
	private List<Style> style;
	
	@OneToMany(mappedBy = "artist")
	private List<People> members;
	

	@ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(
        name = "Artist_Artist", 
        joinColumns = { @JoinColumn(name = "artist_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "related_id") }
    )
	private List<Artist> related_from;
	
	@ManyToMany(mappedBy ="related_from")
	private List<Artist> related_of;
	
	
	/**
	 * @return the members
	 */
	public List<People> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<People> members) {
		this.members = members;
	}

	/**
	 * @return the style
	 */
	public List<Style> getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(List<Style> style) {
		this.style = style;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}


	/**
	 * @return the related_from
	 */
	public List<Artist> getRelated_from() {
		return related_from;
	}

	/**
	 * @param related_from the related_from to set
	 */
	public void setRelated_from(List<Artist> related_from) {
		this.related_from = related_from;
	}

	/**
	 * @return the related_of
	 */
	public List<Artist> getRelated_of() {
		return related_of;
	}

	/**
	 * @param related_of the related_of to set
	 */
	public void setRelated_of(List<Artist> related_of) {
		this.related_of = related_of;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", year=" + year + "]";
	}

	
}
