// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.sps.lib.MapsApiDistanceCalculator;
import com.google.sps.lib.Task;

/**
 * This servlet is not part of the application & solely for testing Matrix API.
 */
@WebServlet("/api/matrix")
public class MatrixAPIServlet extends HttpServlet {

   /**
   * Handles server side GET requests.
   */
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException 
  {
    List<Task> taskList = new ArrayList<>(Arrays.asList(
      new Task("1", 28.7041, 28.7041, 77.1025, 77.1025),
      new Task("2", 28.7041, 28.7041, 77.1025, 77.1025), 
      new Task("3", 28.7041, 28.7041, 77.1025, 77.1025),
      new Task("4", 28.7041, 28.7041, 77.1025, 77.1025), 
      new Task("5", 28.7041, 28.7041, 77.1025, 77.1025)));
      
    double matrixAPIResponse[][] = new MapsApiDistanceCalculator().findDistance(taskList);
    response.getWriter().write("Successful Request");
    response.getWriter().flush();
    response.getWriter().close();
  }
}