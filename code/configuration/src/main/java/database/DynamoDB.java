package database;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDB {
    private static DynamoDbEnhancedClient INSTANCE_MAPPER;
    static AwsBasicCredentials awsCreds = AwsBasicCredentials.create(
            "AKIA4AYSRE4ZEVJAI2CP",
            "ZA/3DXpyS8g2+zx5fUJWfjh2G2Yfqq6V4YyyK2mE");

    // DynamoDB Client builder
    private static final DynamoDbClient mapper = DynamoDbClient
            .builder()
            .region(Region.US_EAST_1)
            .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
            .build();

    // Singleton implementation of DynamoDbEnhancedClient.
    public static DynamoDbEnhancedClient getInstanceDynamoDb() {
        if(INSTANCE_MAPPER == null)
            INSTANCE_MAPPER = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(mapper)
                    .build();

        return INSTANCE_MAPPER;
    }
}
