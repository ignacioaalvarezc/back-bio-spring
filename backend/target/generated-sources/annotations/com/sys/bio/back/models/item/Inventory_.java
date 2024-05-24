package com.sys.bio.back.models.item;

import java.time.LocalTime;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inventory.class)
public abstract class Inventory_ {

	public static volatile SingularAttribute<Inventory, Date> date;
	public static volatile SingularAttribute<Inventory, Item> item;
	public static volatile SingularAttribute<Inventory, Integer> amount;
	public static volatile SingularAttribute<Inventory, LocalTime> hour;
	public static volatile SingularAttribute<Inventory, Long> inventoryId;
	public static volatile SingularAttribute<Inventory, Boolean> type;

	public static final String DATE = "date";
	public static final String ITEM = "item";
	public static final String AMOUNT = "amount";
	public static final String HOUR = "hour";
	public static final String INVENTORY_ID = "inventoryId";
	public static final String TYPE = "type";

}

