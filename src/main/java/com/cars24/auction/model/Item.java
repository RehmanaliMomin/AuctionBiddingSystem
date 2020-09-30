package com.cars24.auction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "itemCode"
        })
})

public class Item {

    @Id
    private String itemCode;

    private String itemName;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
