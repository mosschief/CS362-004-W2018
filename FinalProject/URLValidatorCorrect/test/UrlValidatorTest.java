/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1739358 $
 */
public class UrlValidatorTest extends TestCase {

   private final boolean printStatus = false;
   private final boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   @Override
protected void setUp() {
      for (int index = 0; index < testPartsIndex.length - 1; index++) {
         testPartsIndex[index] = 0;
      }
   }

   public void testIsValid() {
        testIsValid(testUrlParts, 1);
        setUp();
//        int options =
//            UrlValidator.ALLOW_2_SLASHES
//                + UrlValidator.ALLOW_ALL_SCHEMES
//                + UrlValidator.NO_FRAGMENTS;
//    
//        testIsValid(testUrlPartsOptions, options);
   }

   public void testIsValidScheme() {


   }

   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   public void testIsValid(Object[] testObjects, long allowAllSchemes) {

	      //UrlValidator urlVal = new UrlValidator(null, allowAllSchemes);

      int statusPerLine = 60;
      int printed = 0;
      int count = 1;

      do {
          StringBuilder testBuffer = new StringBuilder();
         boolean expected = true;
         for (int testPartsIndexIndex = 0; testPartsIndexIndex < testPartsIndex.length; ++testPartsIndexIndex) {
            int index = testPartsIndex[testPartsIndexIndex];
            String[] part = (String[]) testObjects[testPartsIndexIndex];
            testBuffer.append(part[index]);


         }
         String url = testBuffer.toString();
         System.out.println(url);
         System.out.println(count);
         count++;
         
         

      } while (incrementTestPartsIndex(testPartsIndex, testObjects));
      if (printStatus) {
         System.out.println();
      }
   }


   static boolean incrementTestPartsIndex(int[] testPartsIndex, Object[] testParts) {
      boolean carry = true;  //add 1 to lowest order part.
      boolean maxIndex = true;
      for (int testPartsIndexIndex = testPartsIndex.length - 1; testPartsIndexIndex >= 0; --testPartsIndexIndex) {
         int index = testPartsIndex[testPartsIndexIndex];
         String[] part = (String[]) testParts[testPartsIndexIndex];
         if (carry) {
            if (index < part.length - 1) {
               index++;
               testPartsIndex[testPartsIndexIndex] = index;
               carry = false;
            } else {
               testPartsIndex[testPartsIndexIndex] = 0;
               carry = true;
            }
         }
         maxIndex &= (index == (part.length - 1));
      }


      return (!maxIndex);
   }

   private String testPartsIndextoString() {
       StringBuilder carryMsg = new StringBuilder("{");
      for (int testPartsIndexIndex = 0; testPartsIndexIndex < testPartsIndex.length; ++testPartsIndexIndex) {
         carryMsg.append(testPartsIndex[testPartsIndexIndex]);
         if (testPartsIndexIndex < testPartsIndex.length - 1) {
            carryMsg.append(',');
         } else {
            carryMsg.append('}');
         }
      }
      return carryMsg.toString();

   }

   public void testValidateUrl() {
      assertTrue(true);
   }

   /**
    * Only used to debug the unit tests.
    * @param argv
    */
   public static void main(String[] argv) {

	  UrlValidatorTest fct = new UrlValidatorTest("url test");
      fct.setUp();
      fct.testIsValid();
   }
   //-------------------- Test data for creating a composite URL
   /**
    * The data given below approximates the 4 parts of a URL
    * <scheme>://<authority><path>?<query> except that the port number
    * is broken out of authority to increase the number of permutations.
    * A complete URL is composed of a scheme+authority+port+path+query,
    * all of which must be individually valid for the entire URL to be considered
    * valid.
    */
   String[] testUrlScheme = {"http://",
                               "ftp://",
                               "h3t://",
                               "3ht://",
                               "http:/",
                               "http:",
                               "http/",
                               "://",
                               "",
                               };

   String[] testUrlAuthority = {"www.google.com",
                                "go.com",
                                "go.au",
                                "0.0.0.0",
                                "255.255.255.255",
                                "256.256.256.256",
                                "255.com",
                                "1.2.3.4.5",
                                "1.2.3.4.",
                                "1.2.3",
                                ".1.2.3.4",
                                "go.a",
                                "go.a1a",
                                "go.1aa",
                                "aaa.",
                                ".aaa",
                                "aaa",
                                "",
                                };
     String[] testUrlPort = {":80",
                             ":65535",
                             ":0",
                             "",
                             ":-1",
                             ":65636",
                             ":65a"
   };
      String[] testPath = {"/test1",
                          "/t123",
                          "/$23",
                          "/..",
                          "/../",
                          "/test1/",
                          "",
                          "/test1/file",
                          "/..//file",
                          "/test1//file"
                          };
   //Test allow2slash, noFragment
   int[] testUrlPathOptions = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    String[] testUrlQuery = {"?action=view",
                              "?action=edit&mode=up",
                              "",
   };

   Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
   Object[] testUrlPartsOptions = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPathOptions, testUrlQuery};
   int[] testPartsIndex = {0, 0, 0, 0, 0};




}
