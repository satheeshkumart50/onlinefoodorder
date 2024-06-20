Online Food Ordering (OFO) Microservices

This repository contains the code for the Online Food Ordering (OFO) microservices application. The application is designed using a microservices architecture and is deployed on AWS using Elastic Beanstalk and Kubernetes.
Table of Contents

    Overview
    Microservices
    Deployment
        Elastic Beanstalk
        Kubernetes
    Technologies Used

Overview

The Online Food Ordering application is designed to provide a seamless and scalable solution for managing food orders. The application is broken down into several microservices, each responsible for a specific functionality.
Microservices

The following microservices are part of this application:

    ofo-gateway: API Gateway for routing requests to appropriate services.
    order-service: Manages customer orders.
    payment-service: Handles payment transactions.
    restaurant-service: Manages restaurant information and menus.
    review-service: Manages customer reviews and ratings.
    search-service: Provides search functionality for restaurants and dishes.
    security-service: Handles authentication and authorization.
    user-service: Manages user information and profiles.

Deployment

The deployment-elasticbeanstack directory contains the configuration and scripts for deploying the application using AWS Elastic Beanstalk.
Kubernetes

The deployment-kubernetes directory contains the configuration files for deploying the application on a Kubernetes cluster.

Technologies Used

    Java/Spring Boot: For developing the microservices.
    Docker: For containerizing the microservices.
    AWS Elastic Beanstalk: For deploying and managing the application in the cloud.
    Kubernetes: For orchestrating the deployment of the application.
    My-SQL: SQL Database used by User-service
    Mongo DD: NoSQL Database used by all other services
