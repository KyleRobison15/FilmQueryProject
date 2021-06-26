package com.skilldistillery.filmquery.entities;

public class InventoryItem {

	private int inventoryId;
	private int filmId;
	private int storeId;
	private String mediaCondition;
	private String lastUpdate;
	
	public InventoryItem() {
		
	}

	public InventoryItem(int inventoryId, int filmId, int storeId, String mediaCondition, String lastUpdate) {
		super();
		this.inventoryId = inventoryId;
		this.filmId = filmId;
		this.storeId = storeId;
		this.mediaCondition = mediaCondition;
		this.lastUpdate = lastUpdate;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getMediaCondition() {
		return mediaCondition;
	}

	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setlastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InventoryItem [inventoryId=").append(inventoryId).append(", filmId=").append(filmId)
				.append(", storeId=").append(storeId).append(", mediaCondition=").append(mediaCondition)
				.append(", lastUpdate=").append(lastUpdate).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + filmId;
		result = prime * result + inventoryId;
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((mediaCondition == null) ? 0 : mediaCondition.hashCode());
		result = prime * result + storeId;
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
		InventoryItem other = (InventoryItem) obj;
		if (filmId != other.filmId)
			return false;
		if (inventoryId != other.inventoryId)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (mediaCondition == null) {
			if (other.mediaCondition != null)
				return false;
		} else if (!mediaCondition.equals(other.mediaCondition))
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}
	
}
