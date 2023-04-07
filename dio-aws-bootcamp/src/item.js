"use strict"

const {v4} = require("uuid");
const AWS = require("aws-sdk");

const dynamoDB = new AWS.DynamoDB.DocumentClient();

const insertItem = async (event) => {

    const {item} = JSON.parse(event.body);
    const createdAt = new Date().toISOString();
    const id = v4();

    const newItem = {
        id,
        item,
        createdAt,
        itemStatus: false
    }

    await dynamoDB.put(
        {
            TableName:"Item",
            Item: newItem
        }
    ).promise();

    return{
        statusCode: 201,
        body: JSON.stringify(newItem)
    };
}

const updateItem = async (event) => {
    const {itemStatus} = JSON.parse(event.body);
    const {id} = event.pathParameters
    
    await dynamoDB.update({
        TableName: "Item",
        Key: {id},
        UpdateExpression: 'set itemStatus = :itemStatus',
        ExpressionAttributeValues: {
          ':itemStatus': itemStatus
        },
        ReturnValues: "ALL_NEW"
    }).promise()
    
    return {
        statusCode: 200,
        body: JSON.stringify(
          { msg: 'Item atualizado'}
        ),
    };
    
}

const getItens = async (event) => {
    
    let itens;

    try {
        const results = await dynamoDB.scan({
            TableName: "Item"
        }).promise();

        itens = results.Items; 

    } catch (error) {
        console.log(error);
    }

    return {
        statusCode: 200,
        body: JSON.stringify(itens)
    }
}

const getItem = async (event) => {
    
    const {id} = event.pathParameters;
    let item;

    try {
        const result = await dynamoDB.get({
            TableName: "Item",
            Key: {id}
        }).promise();

        item = result.Item;

    } catch (error) {
        console.log(error)
    }

    return {
        statusCode: 200,
        body: JSON.stringify(item)
    }
}

exports.handler = async (event) => {
    const path = event.path;
    const method = event.httpMethod;
    let id; 
        
    if(event.pathParameters){
        id = event.pathParameters;
    }

    try{          
        if(path == '/item' && method == 'POST'){
            return insertItem(event);
        }
        if(path == `/item/${id}` && method == "PUT"){
            return updateItem(event);
        }
        if(path == '/item' && method == 'GET'){
            return getItens(event);
        }
        if(path == `/item/${id}` && method == 'GET'){
            return getItem(event);
        }          
    } catch (err) {
        statusCode = 400;
        return err.message;
    }
}