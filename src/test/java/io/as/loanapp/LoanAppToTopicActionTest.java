package io.as.loanapp;

import org.junit.Test;

// This class was initially generated based on the .proto definition by Akka Serverless tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class LoanAppToTopicActionTest {

  @Test
  public void exampleTest() {
    LoanAppToTopicActionTestKit testKit = LoanAppToTopicActionTestKit.of(LoanAppToTopicAction::new);
    // use the testkit to execute a command
    // ActionResult<SomeResponse> result = testKit.someOperation(SomeRequest);
    // verify the response
    // SomeResponse actualResponse = result.getReply();
    // assertEquals(expectedResponse, actualResponse);
  }

  @Test
  public void onApprovedTest() {
    LoanAppToTopicActionTestKit testKit = LoanAppToTopicActionTestKit.of(LoanAppToTopicAction::new);
    // ActionResult<Empty> result = testKit.onApproved(LoanAppDomain.Approved.newBuilder()...build());
  }

  @Test
  public void onDeclinedTest() {
    LoanAppToTopicActionTestKit testKit = LoanAppToTopicActionTestKit.of(LoanAppToTopicAction::new);
    // ActionResult<Empty> result = testKit.onDeclined(LoanAppDomain.Declined.newBuilder()...build());
  }

  @Test
  public void ignoreOtherEventsTest() {
    LoanAppToTopicActionTestKit testKit = LoanAppToTopicActionTestKit.of(LoanAppToTopicAction::new);
    // ActionResult<Empty> result = testKit.ignoreOtherEvents(Any.newBuilder()...build());
  }

}
