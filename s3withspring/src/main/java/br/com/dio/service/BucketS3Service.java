package br.com.dio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import br.com.dio.config.AmazonConfig;

@Service
public class BucketS3Service {
	
	@Autowired
	private AmazonConfig amazonConfig;

	public Bucket getBucket(String bucketName) {
		AmazonS3 s3 = amazonConfig.getAmazonConfig();
		List<Bucket> buckets = s3.listBuckets();
		for (Bucket bucket : buckets) {
			if(bucket.getName().equals(bucketName)) {
				return bucket;
			}
		}
		return null;
	}
	
	public List<Bucket> getListBucket() {
		AmazonS3 s3 = amazonConfig.getAmazonConfig();
		return s3.listBuckets();
	}
	
	public void salvarNoBucket(Bucket bucket) {
	}
	
	/**Gets the list of object summaries describing the objects stored in theS3 bucket. 
	* Listings for large buckets can be truncated for performance reasons. 
	* Always check the ListObjectsV2Result.isTruncated() method to see if the 
	* returned listing is complete or if additional calls are needed to get more results. 
	* Callers can pass the nextContinuationToken into subsequent requests to get additional results.
	 * @return */
	public List<S3ObjectSummary> getListObjetoNoBucket(String name) {
		AmazonS3 s3 = amazonConfig.getAmazonConfig();
		ListObjectsV2Result listObjectsV2 = s3.listObjectsV2(name);
		return listObjectsV2.getObjectSummaries();
	}
}
