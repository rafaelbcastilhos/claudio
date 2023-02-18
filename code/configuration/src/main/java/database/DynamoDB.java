package database;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDB {
    private static DynamoDbEnhancedClient INSTANCE_MAPPER;

    private static final DynamoDbClient mapper = DynamoDbClient
            .builder()
            .region(Region.US_EAST_1)
            .build();

    public static DynamoDbEnhancedClient getInstanceDynamoDb() {
        if(INSTANCE_MAPPER == null)
            INSTANCE_MAPPER = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(mapper)
                    .build();

        return INSTANCE_MAPPER;
    }
}
