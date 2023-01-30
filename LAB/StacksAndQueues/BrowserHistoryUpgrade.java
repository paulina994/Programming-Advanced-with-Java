package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {

        static ArrayDeque<String> webForwardQueue = new ArrayDeque<>();
        static ArrayDeque<String> webHistoryStack = new ArrayDeque<>();

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            while (!userInput.equals("Home")) {
                switch (userInput) {
                    case "back":
                        processBackCommand();
                        break;
                    case "forward":
                        processForwardCommand();
                        break;
                    default:
                        //"normal" navigation mode:
                        processNormalWebPageCommand(userInput);
                }
                userInput = scan.nextLine();
            }
        }

        private static void processNormalWebPageCommand(String userInput) {
            webForwardQueue.clear();
            loadWebPage(userInput);
        }

        private static void processForwardCommand() {
            if (webForwardQueue.isEmpty()) {
                System.out.println("no next URLs");
            } else {
                loadWebPage(webForwardQueue.poll());
            }
        }

        private static void processBackCommand() {

            if (webHistoryStack.size() < 2) {
                System.out.println("no previous URLs");
            } else {
                //Used to remove and assign the current page what we are on to the forwardingQueue
                String currentPageThatHasToBeQueuedForForwarding = webHistoryStack.pop();
                loadWebPage(webHistoryStack.pop());
                addWebPageToTheForwardQueue(currentPageThatHasToBeQueuedForForwarding);
            }
        }

        private static void addWebPageToTheForwardQueue(String userInput) {
            webForwardQueue.offerFirst(userInput);
        }

        private static void loadWebPage(String userInput) {
            System.out.println(userInput);
            addWebPageToTheHistoryStack(userInput);
        }

        private static void addWebPageToTheHistoryStack(String userInput) {
            webHistoryStack.push(userInput);
        }
    }