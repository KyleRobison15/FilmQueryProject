package com.skilldistillery.filmquery.entities;

public class Language {
	
	private int id;
	private String languageName;
	
	public Language() {
		
	}

	public Language(int id, String languageName) {
		super();
		this.id = id;
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Language [id=").append(id).append(", languageName=").append(languageName).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((languageName == null) ? 0 : languageName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		if (id != other.id)
			return false;
		if (languageName == null) {
			if (other.languageName != null)
				return false;
		} else if (!languageName.equals(other.languageName))
			return false;
		return true;
	}
	
	
	
}
