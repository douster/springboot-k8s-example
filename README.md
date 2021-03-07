# Springboot as service in kubernate (k8s)


## configure kubernate

System required: 
    https://www.docker.com/products/docker-desktop


## Build application
using your docker hub, edit the pom.xml to replace
  yourname/springboot-k8s-example
  

```bash
mvn clean package dockerfile:build
```

## create deployment springboot into k8s

```bash
kubectl run springboot-k8s-example --image=yourname/springboot-k8s-example:0.0.1-SNAPSHOT --port=8080
```

Alternatively, create a deployment.yaml and apply it
```bash
kubectl create deployment springboot-k8s-example --image=yourname/springboot-k8s-example:0.0.1-SNAPSHOT --dry-run -o yaml > deployment.yaml
kubectl apply -f deployment.yaml
```

```bash
kubectl get deployments
```

```bash
NAME                     READY   UP-TO-DATE   AVAILABLE   AGE
springboot-k8s-example   0/1     1            0           41s
```

## Expose port

Export the service

```bash
kubectl expose deployment springboot-k8s-example \
--type=LoadBalancer \
--name=springboot-k8s-service-example \
--port=8080 \
--target-port=8080
```

Get services
```
kubectl get services

curl http://localhost:8080/api/hello
```


