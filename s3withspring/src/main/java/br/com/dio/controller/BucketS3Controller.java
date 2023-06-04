package br.com.dio.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.Bucket;

import br.com.dio.service.BucketS3Service;

@RestController
@RequestMapping("/api/s3/v1/buckets")
public class BucketS3Controller {
	@Autowired
	private BucketS3Service bucketS3Service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Object> listarBuckets() {
		List<Bucket> listBucket = bucketS3Service.getListBucket();
		for (Bucket bucket : listBucket) {
			System.out.println(bucket.getName());
		}
		return Arrays.asList(listBucket.stream().map(b -> b.getName()).toArray());
	}
	
	@RequestMapping(value = "/{name}/objects")
	public List<Object> listarObjetos(@PathVariable String name) {
		return Arrays.asList(bucketS3Service.getListObjetoNoBucket(name).stream().map(o -> o.getKey()).toArray());
	}
}
