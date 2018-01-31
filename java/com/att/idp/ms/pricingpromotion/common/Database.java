package com.att.idp.ms.pricingpromotion.common;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.couchbase.client.core.CouchbaseException;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.query.AsyncN1qlQueryRow;
import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;

import rx.Observable;
// TODO: Auto-generated Javadoc
/**
 * Configuration and beans for couchbase bucket.
 *
 * @author gv225y
 * @since 1.0
 */
//@Configuration
@Component
@SuppressWarnings("PMD")
public class Database {

	/** EELFLogger instance. */
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(Database.class);

	
    /** The nodes. */
   /* @Value("${couchbase.nodes}")
    private String nodes;*/
    //private final List<String> nodes = new ArrayList<String>();

    /** The bucket. */
  /*  @Value("${couchbase.bucket}")
    private String bucket;*/

    /** The password. *//*
    @Value("${couchbase.password}")
    private String password;
    
    *//** The username. *//*
    @Value("${couchbase.password}")
    private String username;*/

    /**
     * Gets the username.
     *
     * @return the username
     *//*
    public String getUsername() {
		return username;
	}

	*//**
	 * Sets the username.
	 *
	 * @param username the new username
	 *//*
	public void setUsername(final String username) {
		this.username = username;
	}

	*//**
	 * Gets the nodes.
	 *
	 * @return the nodes
	 *//*
	public List<String> getNodes() {
    	//nodes.add("localhost");
    
        return nodes;
    }*/

    /**
     * Gets the bucket.
     *
     * @return the bucket
     */
   /* public String getBucket() {
        return bucket;
    }

    *//**
     * Gets the password.
     *
     * @return the password
     *//*
    public String getPassword() {
        return password;
    }*/
    /**
     * bucketObj
     */
    public Bucket bucketObj;
    /**
     * cluster
     */
    public Cluster cluster;
    /**
     * offerLatch
     */
    public CountDownLatch offerLatch;
    
    
    /**
     * getcouchDbConnection
     */
    public void getcouchDbConnection()
    {
    	/*cluster=CouchbaseCluster.create(nodes);
    	 * 
    	offerLatch = new CountDownLatch(1);
    	bucketObj = cluster.openBucket(bucket,password);*/
    	DefaultCouchbaseEnvironment.builder().connectTimeout(30000);
    	cluster=CouchbaseCluster.create("localhost:8091");
    	offerLatch = new CountDownLatch(1);
    	bucketObj = cluster.openBucket("default");
    }

    /**
     * excuteQuery
     * @param queryPrice
     * @return
     */
    @SuppressWarnings("PMD.GuardLogStatement")
    public Iterator<N1qlQueryRow> excuteQuery(String queryPrice)
    {
    	final N1qlParams offerParams = N1qlParams.build().adhoc(false);
    	final N1qlQuery offerQuery = N1qlQuery.simple(queryPrice, offerParams);
    	
    	if(null ==bucketObj/* && bucketObj.close() !=false*/)
    	{
    		log.error("Couchbase Db connection is null");
    		return null;
    	}
    	else
    	{
    		final N1qlQueryResult queryResult =
    				bucketObj.query(N1qlQuery.simple(queryPrice));
    		bucketObj.async().query(offerQuery).flatMap(result -> {
    			log.info("flatMap: (" + Thread.currentThread().getName() + ")");
    			return result.errors().flatMap(err -> Observable.<AsyncN1qlQueryRow>error(new CouchbaseException("N1QL Error/Warning: "+err))).switchIfEmpty(result.rows());
    		})
    		.map(AsyncN1qlQueryRow::value)
    		.forEach(row -> {
    			offerLatch.countDown();
    			log.info("offer keyset="+row);
    		});
    		cluster.disconnect();
    		return queryResult.rows();
    	
    	}

    }
    
}

