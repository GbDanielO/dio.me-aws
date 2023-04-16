"use strict"

var AWS = require('aws-sdk');
const dynamodb = new AWS.DynamoDB.DocumentClient();

exports.handler = async (event) => {
       
    let {id, price} = JSON.parse(event.body);
    
    const params = {
      TableName : 'Items',
      Item: {
         id: id,
         price: price
      }
    }
    
    try {
        
        await dynamodb.put(params).promise();
        
        return{
            statusCode: 200,
            responseBody: JSON.stringify('Item inserido com sucesso!')
        }
        
    } catch (err) {
        return{
            statusCode: 400,
            responseBody: JSON.stringify(err)
        }
    }
        
};