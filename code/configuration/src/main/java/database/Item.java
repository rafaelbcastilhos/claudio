package database;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Item {
    String id;
    String type;
    String size;
    String method;
    Long bytesSerialize;
    Long timeSerialize;
    Long timeRequest;
    Long timeDeserialize;

    public Item() {}

    public Item(String id, String type, String size, String method, Long bytesSerialize, Long timeSerialize, Long timeRequest) {
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

    public Long getBytesSerialize() {
        return bytesSerialize;
    }

    public void setBytesSerialize(Long bytesSerialize) {
        this.bytesSerialize = bytesSerialize;
    }

    public Long getTimeSerialize() {
        return timeSerialize;
    }

    public void setTimeSerialize(Long timeSerialize) {
        this.timeSerialize = timeSerialize;
    }

    public Long getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(Long timeRequest) {
        this.timeRequest = timeRequest;
    }

    public Long getTimeDeserialize() {
        return timeDeserialize;
    }

    public void setTimeDeserialize(Long timeDeserialize) {
        this.timeDeserialize = timeDeserialize;
    }
}
