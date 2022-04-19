package io.as.loanapp;

import com.akkaserverless.javasdk.action.ActionCreationContext;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.as.loanapp.domain.LoanAppDomain;

import static com.google.protobuf.Empty.getDefaultInstance;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
// This is the implementation for the Action Service described in your io/as/loanapp/loan_app_topic.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class LoanAppToTopicAction extends AbstractLoanAppToTopicAction {

  public LoanAppToTopicAction(ActionCreationContext creationContext) {}

  @Override
  public Effect<LoanAppToTopicApi.ApprovedTopic> onApproved(LoanAppDomain.Approved approved) {
    LoanAppToTopicApi.ApprovedTopic topicEvent = LoanAppToTopicApi.ApprovedTopic.newBuilder()
            .setLoanAppId(approved.getLoanAppId())
            .setEventTimestamp(approved.getEventTimestamp())
            .build();
    return effects().reply(topicEvent);
  }
  @Override
  public Effect<LoanAppToTopicApi.DeclinedTopic> onDeclined(LoanAppDomain.Declined declined) {
    LoanAppToTopicApi.DeclinedTopic topicEvent = LoanAppToTopicApi.DeclinedTopic.newBuilder()
            .setLoanAppId(declined.getLoanAppId())
            .setReason(declined.getReason())
            .setEventTimestamp(declined.getEventTimestamp())
            .build();
    return effects().reply(topicEvent);
  }
  @Override
  public Effect<Empty> ignoreOtherEvents(Any any) {
    return effects().reply(getDefaultInstance());
  }
}
