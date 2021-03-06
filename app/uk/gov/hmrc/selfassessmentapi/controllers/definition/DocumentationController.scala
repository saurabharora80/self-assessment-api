/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.selfassessmentapi.controllers.definition
import play.api.http.LazyHttpErrorHandler
import play.api.libs.json.Json
import play.api.mvc.Action
import uk.gov.hmrc.selfassessmentapi.controllers.definition.JsonFormatters._


abstract class DocumentationController extends uk.gov.hmrc.api.controllers.DocumentationController(LazyHttpErrorHandler) {

  override def definition() = Action {
    Ok(Json.toJson(SelfAssessmentApiDefinition.definition))
  }

  override def conf(version: String, file: String) = {
    super.at(s"/public/api/conf/$version", file)
  }
}

object DocumentationController extends DocumentationController
