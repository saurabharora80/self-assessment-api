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

package uk.gov.hmrc.selfassessmentapi.domain.unearnedincome

import play.api.libs.json.JsValue
import play.api.libs.json.Json._
import uk.gov.hmrc.selfassessmentapi.domain._
import uk.gov.hmrc.selfassessmentapi.domain.unearnedincome.SummaryTypes.SavingsIncomes

object SourceType {

  case object UnearnedIncomes extends SourceType {

    override val name: String = "unearned-incomes"
    override val summaryTypes: Seq[SummaryType] = Seq(SavingsIncomes)
    override val example: JsValue = toJson(UnearnedIncome.example)

    override def description(action: String): String =  s"$action an unearned income"
    override val title: String = "Sample unearned income"
    override val fieldDescriptions = Seq(
      FullFieldDescription(name, "name", "String", UnearnedIncome.example.name, "Name of the unearned income")
    )
  }

}
