package model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Item {
    String id;
    String type;
    String size;
    String method;
    Integer bytesSerialize;
    Integer timeSerialize;
    Integer timeRequest;
    Integer timeDeserialize;

    public Item() {}

    public Item(String id, String type, String size, String method, Integer bytesSerialize, Integer timeSerialize, Integer timeRequest) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.method = method;
        this.bytesSerialize = bytesSerialize;
        this.timeSerialize = timeSerialize;
        this.timeRequest = timeRequest;
    }

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getBytesSerialize() {
        return bytesSerialize;
    }

    public void setBytesSerialize(Integer bytesSerialize) {
        this.bytesSerialize = bytesSerialize;
    }

    public Integer getTimeSerialize() {
        return timeSerialize;
    }

    public void setTimeSerialize(Integer timeSerialize) {
        this.timeSerialize = timeSerialize;
    }

    public Integer getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(Integer timeRequest) {
        this.timeRequest = timeRequest;
    }

    public Integer getTimeDeserialize() {
        return timeDeserialize;
    }

    public void setTimeDeserialize(Integer timeDeserialize) {
        this.timeDeserialize = timeDeserialize;
    }
}
