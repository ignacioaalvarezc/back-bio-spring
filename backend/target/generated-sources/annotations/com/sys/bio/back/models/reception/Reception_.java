package com.sys.bio.back.models.reception;

import com.sys.bio.back.models.user.Responsible;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reception.class)
public abstract class Reception_ {

	public static volatile SingularAttribute<Reception, Date> date;
	public static volatile SingularAttribute<Reception, LocalDate> filterDate;
	public static volatile SingularAttribute<Reception, Integer> acceptedBales;
	public static volatile SingularAttribute<Reception, String> reasonRejected;
	public static volatile SingularAttribute<Reception, Double> totalHours;
	public static volatile SingularAttribute<Reception, Responsible> responsible;
	public static volatile SingularAttribute<Reception, LocalTime> startTime;
	public static volatile SingularAttribute<Reception, LocalTime> endTime;
	public static volatile SingularAttribute<Reception, Long> receptionId;
	public static volatile SingularAttribute<Reception, Integer> rejectedBales;

	public static final String DATE = "date";
	public static final String FILTER_DATE = "filterDate";
	public static final String ACCEPTED_BALES = "acceptedBales";
	public static final String REASON_REJECTED = "reasonRejected";
	public static final String TOTAL_HOURS = "totalHours";
	public static final String RESPONSIBLE = "responsible";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String RECEPTION_ID = "receptionId";
	public static final String REJECTED_BALES = "rejectedBales";

}

