/*
 * Copyright 2016 HM Revenue & Customs
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

package uk.gov.hmrc.selfassessmentapi.controllers

import play.api.libs.json.Json
import play.api.mvc.Action
import uk.gov.hmrc.domain.SaUtr
import uk.gov.hmrc.selfassessmentapi.domain.Employment
import scala.concurrent.Future
import play.api.mvc.hal._

trait BaseEmploymentsController extends BaseController {
  def getEmployments(utr: SaUtr) = Action.async { implicit request =>
    val links = Seq(Link("self", uk.gov.hmrc.selfassessmentapi.controllers.live.routes.EmploymentsController.getEmployments(utr).url))
    Future.successful(Ok(halResource(Json.toJson(Employment(s"Employments for utr: $utr")), links)))
  }
}