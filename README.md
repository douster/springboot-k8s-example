# Springboot as service in kubernate (k8s)


## Configure kubernate

System required: 
    https://www.docker.com/products/docker-desktop
    
Enable k8s in the docker-desktop


## Build application
using your docker hub, edit the pom.xml to replace
  yourname/springboot-k8s-example
  

```bash
mvn clean package dockerfile:build
```

## Create deployment springboot into k8s

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

expose the service

```bash
kubectl expose deployment springboot-k8s-example \
--type=LoadBalancer \
--name=springboot-k8s-service-example \
--port=8080 \
--target-port=8080
```

Alternatively, create a service.yaml

```
apiVersion: v1
kind: Service
metadata:
  labels:
    visualize: "true"
  name: springboot-k8s-service-example
spec:
  selector:
    app: springboot-k8s-example
  ports:
  - name: http
    protocol: TCP
    port: 8080
    targetPort: 8080
  type: LoadBalancer
```
```
kubectl apply -f service.yaml
```

get services
```
kubectl get services

curl http://localhost:8080/api/hello
```


