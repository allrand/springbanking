package com.xkxx.springbanking.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class Inventory implements Serializable {
    private static final long serialVersionUID = -580805946179582562L;
    private Logger log = LoggerFactory.getLogger(getClass());
    private static final int DEFAULT_MINTHRESHOLD = 50;
    private static final int DEFAULT_MAXTHRESHOLD = 200;

    private String inventoryId;
    private String name;
    private String heading;
    private String description;
    private String pkginfo;
    private String image;
    private byte[] imgbytes;
    private float price;
    private float cost;
    private int quantity;
    private int category;
    private String notes;
    private boolean isPublic;
    private int minThreshold;
    private int maxThreshold;

    private BackOrder backOrder;
    /**
     * Create a new Inventory.
     *
     * @param key
     *            Inventory Key
     * @param name
     *            Name of inventory item.
     * @param heading
     *            Description heading of inventory item.
     * @param desc
     *            Description of inventory item.
     * @param pkginfo
     *            Package info of inventory item.
     * @param image
     *            Image of inventory item.
     * @param price
     *            Price of inventory item.
     * @param cost
     *            Cost of inventory item.
     * @param quantity
     *            Quantity of inventory items in stock.
     * @param category
     *            Category of inventory item.
     * @param notes
     *            Notes of inventory item.
     * @param isPublic
     *            Access permission of inventory item.
     */
    public Inventory(String key, String name, String heading, String desc, String pkginfo, String image, float price,
                     float cost, int quantity, int category, String notes, boolean isPublic) {
        this.setInventoryId(key);
        log.debug("creating new Inventory, inventoryId=" + this.getInventoryId());
        this.setName(name);
        this.setHeading(heading);
        this.setDescription(desc);
        this.setPkginfo(pkginfo);
        this.setImage(image);
        this.setPrice(price);
        this.setCost(cost);
        this.setQuantity(quantity);
        this.setCategory(category);
        this.setNotes(notes);
        this.setIsPublic(isPublic);
        this.setMinThreshold(DEFAULT_MINTHRESHOLD);
        this.setMaxThreshold(DEFAULT_MAXTHRESHOLD);

    }

    /**
     * Create a new Inventory.
     *
     * @param item
     *            Inventory to use to make a new inventory item.
     */
    public Inventory(Inventory item) {
        this.setInventoryId(item.getInventoryId());
        this.setName(item.getName());
        this.setHeading(item.getHeading());
        this.setDescription(item.getDescription());
        this.setPkginfo(item.getPkginfo());
        this.setImage(item.getImage());
        this.setPrice(item.getPrice());
        this.setCost(item.getCost());
        this.setQuantity(item.getQuantity());
        this.setCategory(item.getCategory());
        this.setNotes(item.getNotes());
        this.setMinThreshold(DEFAULT_MINTHRESHOLD);
        this.setMaxThreshold(DEFAULT_MAXTHRESHOLD);

        setIsPublic(item.isPublic());

        // does not clone BackOrder info
    }

    /**
     * Increase the quantity of this inventory item.
     *
     * @param quantity
     *            The number to increase the inventory by.
     */
    public void increaseInventory(int quantity) {
        this.setQuantity(this.getQuantity() + quantity);
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
    /**
     * Same as getInventoryId. Added for compatability with ShoppingCartItem when used by the Client
     * XJB sample
     *
     * @return String ID of the inventory item
     */
    public String getID() {
        return inventoryId;
    }

    /**
     * Same as setInventoryId. Added for compatability with ShoppingCartItem when used by the Client
     * XJB sample
     *
     */
    public void setID(String id) {
        inventoryId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPkginfo() {
        return pkginfo;
    }

    public void setPkginfo(String pkginfo) {
        this.pkginfo = pkginfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public byte[] getImgbytes() {
        return imgbytes;
    }

    public void setImgbytes(byte[] imgbytes) {
        this.imgbytes = imgbytes;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public int getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(int minThreshold) {
        this.minThreshold = minThreshold;
    }

    public int getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(int maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public BackOrder getBackOrder() {
        return backOrder;
    }

    public void setBackOrder(BackOrder backOrder) {
        this.backOrder = backOrder;
    }
}
