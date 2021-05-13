# README


## Environment

* java 11



## How to test 

Use Altair plugin

    http://localhost:9001/graphql
    
    
Query operation

    query{
      findAll{
        id
        url
        description
      }
    }
    
        
Mutation operation 


    mutation{
      saveComment(id: 5, title: "FAQ ", createdAt: "2020/11/21 13:22:41")
    }


## Test Polymorphic type 

* query interface

        query{
            findVehicle{
              __typename,
             ... on Car {
              id 
              enginePower
        			
            }
              ... on Van {
                id
                enginePower
                isOffRoad
              }
              
            }
          }
          
* Query output          

        {
          "data": {
            "findVehicle": [
              {
                "__typename": "Van",
                "id": "Van100",
                "enginePower": "HP_3000",
                "isOffRoad": true
              },
              {
                "__typename": "Car",
                "id": "Car 120",
                "enginePower": "HP_1500"
              }
            ]
          }
        }
    
* Mutation on interface    
    
        mutation{
          saveCar(id: "Preus 2008", enginePower: HP_1500)
        }

## Test Pagination

* query operation

        query{
            books{
                edges{
                    cursor
                    node{
                       id
                       title
                       author
                    }
                },
                pageInfo{
                      hasPreviousPage
                      hasNextPage
                      startCursor
                      endCursor
                }
            }
        }


* query output

       {
           "data": {
               "books": {
                   "edges": [
                       {
                           "cursor": "c2ltcGxlLWN1cnNvcjA=",
                           "node": {
                               "id": "1245",
                               "title": "Jane Eyre",
                               "author": "Charlot Bronte"
                           }
                       },
                       {
                           "cursor": "c2ltcGxlLWN1cnNvcjE=",
                           "node": {
                               "id": "1285",
                               "title": "Village By the Sea",
                               "author": "Anita Desai"
                           }
                       },
                       {
                           "cursor": "c2ltcGxlLWN1cnNvcjI=",
                           "node": {
                               "id": "1259",
                               "title": "Mother",
                               "author": "Maximum Ghorky"
                           }
                       },
                       {
                           "cursor": "c2ltcGxlLWN1cnNvcjM=",
                           "node": {
                               "id": "1273",
                               "title": "Anne Frank huis",
                               "author": "Anne Frank"
                           }
                       }
                   ],
                   "pageInfo": {
                       "hasPreviousPage": false,
                       "hasNextPage": false,
                       "startCursor": "c2ltcGxlLWN1cnNvcjA=",
                       "endCursor": "c2ltcGxlLWN1cnNvcjM="
                   }
               }
           }
       }

* paginated query operation

       query($first: Int, $after: String){
          books(first: $first, after: $after){
              edges{
                 cursor
                     node{
                       id
                       title
                        author
                     }
                 },
               pageInfo{
                  hasPreviousPage
                  hasNextPage
                  startCursor
                  endCursor
               }

         }
       }

* variables

       {
           "first": 3,
           "after": "c2ltcGxlLWN1cnNvcjA="  
       }
       
       `a cursor value should be placed after the "after"`

## subscription operation

*  use `http://localhost:8085/graphiql` in your browser to test subscriptions

          subscription {
            comments {
              id
              title
              createdAt
            }
          }

Ref : 
    
https://graphql.org/learn/schema/

https://www.howtographql.com/graphql-java/9-filtering/
    
https://developer.okta.com/blog/2020/01/31/java-graphql

polymophic : https://medium.com/better-programming/using-graphql-with-spring-boot-interfaces-and-unions-a76f62d62867

client Library : https://ktor.io/docs/clients-index.html
