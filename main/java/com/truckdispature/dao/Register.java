package com.truckdispature.dao;

import java.rmi.server.SocketSecurityException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.truckdispature.dto.Driver;
import com.truckdispature.dto.DriverEntity;
import com.truckdispature.dto.LoadMaster;
import com.truckdispature.dto.Owner;
import com.truckdispature.dto.Transaction_details;
import com.truckdispature.dto.Truck;
import com.truckdispature.dto.TruckEntity;

@Repository
@Transactional
public class Register {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveOwner(Owner rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.save(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public void saveTruck(Truck rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.save(rdto);
		session.beginTransaction().commit();
		session.close();
	}

	public List<Owner> getOwner() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		String hql = "FROM Owner ORDER BY name";
		Query query = session.createQuery(hql);

		List l = query.list();
		session.close();
		return l;

	}

	public List<TruckEntity> getAllTrucks() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();

		String hql = "SELECT t.trucknumber,t.mileage,t.expiredate,t.maxload,o.ssn,o.name FROM Truck t,Owner o WHERE t.ssn=o.ssn ORDER BY name";

		Query query = session.createQuery(hql);
		List l = query.list();

		List<TruckEntity> list = new ArrayList<TruckEntity>();

		for (Object local : l) {
			TruckEntity truckEntity = new TruckEntity();
			Object[] obj = (Object[]) local;
			truckEntity.setOwnerssn((String) obj[4]);
			truckEntity.setName((String) obj[5]);
			truckEntity.setTrucknumber((String) obj[0]);
			truckEntity.setExpiredate((Date) obj[2]);
			truckEntity.setMaxload((Integer) obj[3]);
			truckEntity.setMileage((Integer) obj[1]);
			list.add(truckEntity);
		}

		session.close();
		return list;
	}

	public void deleteTruck(String trucknumber) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Truck truck = (Truck) session.load(Truck.class, trucknumber);
		Transaction tx = session.beginTransaction();

		session.delete(truck);
		tx.commit();
		session.close();
	}

	public void deleteowner(String ssn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Owner owner = (Owner) session.load(Owner.class, ssn);
		Transaction tx = session.beginTransaction();
		session.delete(owner);

		tx.commit();
		session.close();
	}

	public Owner editowner(String ssn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Owner owner = (Owner) session.load(Owner.class, ssn);
		session.beginTransaction().commit();
		return owner;
	}

	public void updateOwner(Owner rdto) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.load(Owner.class, rdto.getSsn());
		session.saveOrUpdate(rdto);
		session.beginTransaction().commit();
		session.close();
	}

	public Truck edittruck(String trucknumber) {

		Session session = sessionFactory.openSession();
		Truck truck = (Truck) session.load(Truck.class, trucknumber);
		session.beginTransaction().commit();
		return truck;
	}

	public void updateTruck(Truck rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.load(Truck.class, rdto.getTrucknumber());
		session.update(rdto);
		session.beginTransaction().commit();
		session.close();
	}

	public void saveDriver(Driver rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.save(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public List<DriverEntity> getAllDriver() {

		Session session = sessionFactory.openSession();

		String hql1 = "SELECT t.name,t.dob,t.ssn,t.licence_expiration,t.medical_expiration,t.testexpiry,t.assignedtruck,t.truckowner,o.ssn,o.name FROM Driver t,Owner o WHERE t.truckowner=o.ssn ORDER BY t.name";

		Query query = session.createQuery(hql1);
		List l = query.list();

		List<DriverEntity> list = new ArrayList<DriverEntity>();

		for (Object local : l) {
			DriverEntity driverenty = new DriverEntity();

			Object[] obj = (Object[]) local;
			// System.out.println("Owner name is= " + obj[11]);
			driverenty.setName((String) obj[0]);
			driverenty.setDob((Date) obj[1]);
			driverenty.setSsn((String) obj[2]);
			driverenty.setLicence_expiration((Date) obj[3]);
			driverenty.setMedical_expiration((Date) obj[4]);
			driverenty.setTestexpiry((Date) obj[5]);
			driverenty.setAssignedtruck((String) obj[6]);
			driverenty.setOwnername((String) obj[9]);

			list.add(driverenty);

		}

		session.close();
		return list;

	}

	public void deleteDriver(String ssn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Driver driver = (Driver) session.load(Driver.class, ssn);
		Transaction tx = session.beginTransaction();
		session.delete(driver);
		tx.commit();
		session.close();

	}

	public Driver editdriver(String ssn) {

		Session session = sessionFactory.openSession();
		Driver driver = (Driver) session.load(Driver.class, ssn);
		session.beginTransaction().commit();
		return driver;
	}

	public void updateDriver(Driver rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.load(Driver.class, rdto.getSsn());
		session.saveOrUpdate(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public List<String> getAllExpirydetails() {

		List<String> stringlist = new ArrayList<String>();
		Session session = sessionFactory.openSession();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		// manipulate date
		c.add(Calendar.YEAR, 0);
		c.add(Calendar.MONTH, 2);
		c.add(Calendar.DATE, 0);
		java.util.Date currentDatePlusOne = c.getTime();
		java.sql.Date sDate = new java.sql.Date(currentDatePlusOne.getTime());

		String hql0 = "FROM Driver WHERE licence_expiration BETWEEN '" + dateFormat.format(currentDate) + "' and '"
				+ sDate + "' ";
		Query query = session.createQuery(hql0);
		List<Driver> listoflicenceExpire = query.list();

		for (Driver d : listoflicenceExpire) {

			long numberOfDays = daysBetween(d.getLicence_expiration(), currentDate);

			String str = "<p1>Driving Licence of <b> " + d.getName() + "</b> is about to expire in <b>"
					+ (numberOfDays + 1) + "</b> Days <b>(" + d.getLicence_expiration() + ")</b> </p1>";
			stringlist.add(str);
		}

		// --------------------------------------
		String hql1 = "FROM Driver WHERE medical_expiration BETWEEN '" + dateFormat.format(currentDate) + "' and '"
				+ sDate + "' ";
		Query query1 = session.createQuery(hql1);
		List<Driver> listofmedicalexpire = query1.list();

		for (Driver d : listofmedicalexpire) {
			long numberOfDays = daysBetween(d.getLicence_expiration(), currentDate);
			String str = "<p2>Medical card of <b> " + d.getName() + "</b> is about to expire in <b>"
					+ (numberOfDays + 1) + "</b> Days <b>(" + d.getMedical_expiration() + ") </b></p2>";

			stringlist.add(str);
		}

		// ----------------------------
		String hql2 = "FROM Driver WHERE testexpiry BETWEEN '" + dateFormat.format(currentDate) + "' and '" + sDate
				+ "' ";

		Query query2 = session.createQuery(hql2);
		List<Driver> listofdrugtestexpire = query2.list();

		for (Driver d : listofdrugtestexpire) {
			long numberOfDays = daysBetween(d.getLicence_expiration(), currentDate);
			String str = "<p3>Drug Test of <b>" + d.getName() + "</b> is about to expire in <b>" + (numberOfDays + 1)
					+ "</b> Days <b> (" + d.getTestexpiry() + ")</b><p3>";
			stringlist.add(str);
		}

		session.close();
		return stringlist;
	}

	public void addload(LoadMaster rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.save(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public List<LoadMaster> getAllLoad() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "FROM LoadMaster WHERE status = 1 ";
		Query query = session.createQuery(hql);
		List l = query.list();
		session.close();
		return l;

	}

	public void deleteLoad(String loadnumber) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		LoadMaster loadmaster = (LoadMaster) session.load(LoadMaster.class, loadnumber);
		Transaction tx = session.beginTransaction();
		session.delete(loadmaster);
		tx.commit();
		session.close();

	}

	public LoadMaster editLoad(Integer loadnumber) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		LoadMaster loadmaster = (LoadMaster) session.load(LoadMaster.class, loadnumber);
		session.beginTransaction().commit();
		return loadmaster;

	}

	public void updateLoad(LoadMaster rdto) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.load(LoadMaster.class, rdto.getLoadNumber());
		session.saveOrUpdate(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public void addinstallment(Transaction_details rdto) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		rdto.setDatetime(timestamp);
		session.save(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public LoadMaster getLoadnumber(Integer lid) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		LoadMaster load = (LoadMaster) session.load(LoadMaster.class, lid);
		session.beginTransaction().commit();
		return load;
	}

	public void addTotalAdvance(Transaction_details rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		LoadMaster load = (LoadMaster) session.load(LoadMaster.class, rdto.getLoadnumber());
		load.setTotalamountpaid(load.getTotalamountpaid() + rdto.getAdvance());
		session.saveOrUpdate(load);
		session.beginTransaction().commit();
		session.close();

	}

	public List<LoadMaster> getAllLoadclose() {

		Session session = sessionFactory.openSession();
		String hql = "FROM LoadMaster WHERE status = 0 ORDER BY pickupDate DESC";
		Query query = session.createQuery(hql);
		List l = query.list();
		session.close();
		return l;

	}

	public List<Transaction_details> getTrasactionDetails(Integer lid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "FROM Transaction_details WHERE loadnumber= '" + lid + "' ORDER BY datetime DESC";
		Query query = session.createQuery(hql);
		List<Transaction_details> l = query.list();
		session.close();
		return l;

	}

	public void closeLoad(Integer lid) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		LoadMaster load = (LoadMaster) session.load(LoadMaster.class, lid);
		session.beginTransaction().commit();
		load.setStatus(0);
		session.saveOrUpdate(load);
		session.beginTransaction().commit();
		session.close();

	}

	public Double getlastadvance(Integer loadnumber) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "SELECT grossaftercommission FROM Transaction_details WHERE loadnumber = '" + loadnumber
				+ "' ORDER BY datetime DESC LIMIT 0,1  ";
		SQLQuery query = session.createSQLQuery(hql);
		List<Double> list = query.list();
		Double gross = list.get(0);
		session.close();
		return gross;
	}

	public long daysBetween(Date one, java.util.Date currentDatePlusOne) {
		long difference = (one.getTime() - currentDatePlusOne.getTime()) / 86400000;
		return Math.abs(difference);
	}

	public String getownerDetails(String truckNumber) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "SELECT t.trucknumber,o.name FROM Truck t,Owner o WHERE t.trucknumber='" + truckNumber
				+ "' and t.ssn=o.ssn";

		Query query = session.createQuery(hql);
		List l = query.list();

		String ownerName = "";

		for (Object local : l) {

			Object[] obj = (Object[]) local;

			ownerName = (String) obj[1];

		}

		return ownerName;
	}

	public Transaction_details getTransaction(Integer transId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction_details transaction_details = (Transaction_details) session.load(Transaction_details.class,
				transId);
		session.beginTransaction().commit();

		return transaction_details;
	}

	public void updateEmi(Transaction_details rdto) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		session.load(Transaction_details.class, rdto.getTransno());
		session.saveOrUpdate(rdto);
		session.beginTransaction().commit();
		session.close();

	}

	public Transaction_details getTransactionbefor(Integer loadNumber) {
		// TODO Auto-generated method stub
		System.out.println("hello call");
		Session session = sessionFactory.openSession();
		String hql = "SELECT * FROM transaction_details WHERE loadnumber = " + loadNumber
				+ " ORDER BY datetime DESC LIMIT 1,1  ";
		SQLQuery query = session.createSQLQuery(hql);
		List list = query.list();

		Transaction_details td = new Transaction_details();
		for (Object local : list) {

			Object[] obj = (Object[]) local;

			td.setTransno((Integer) obj[0]);
			td.setAdvance((Double) obj[1]);
			td.setAdvancetype((String) obj[2]);
			td.setDatetime((Timestamp) obj[3]);
			td.setGrossaftercommission((Double) obj[4]);
			td.setLoadnumber((Integer) obj[5]);

		}

		session.close();
		return td;
	}

	public Integer getLastTransId(Integer loadnumber) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		String hql = "SELECT transno FROM Transaction_details WHERE loadnumber = '" + loadnumber
				+ "' ORDER BY datetime DESC LIMIT 0,1  ";
		SQLQuery query = session.createSQLQuery(hql);
		List<Integer> list = query.list();
		Integer transid = list.get(0);
		session.close();
		return transid;
	}

}
