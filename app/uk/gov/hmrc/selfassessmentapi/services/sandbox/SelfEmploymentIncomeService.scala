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

package uk.gov.hmrc.selfassessmentapi.services.sandbox
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.domain.SaUtr
import uk.gov.hmrc.selfassessmentapi.domain.{SelfEmploymentId, SelfEmploymentIncome, SelfEmploymentIncomeId, SelfEmploymentIncomeType}

import scala.concurrent.Future

object SelfEmploymentIncomeService extends uk.gov.hmrc.selfassessmentapi.services.SelfEmploymentIncomeService {
  override def create(selfEmploymentIncome: SelfEmploymentIncome): Future[SelfEmploymentIncomeId] = Future.successful(BSONObjectID.generate.stringify)

  override def findBySelfEmploymentIncomeId(utr: SaUtr, selfEmploymentId: SelfEmploymentId, selfEmploymentIncomeId: SelfEmploymentIncomeId): Future[Option[SelfEmploymentIncome]] =
    Future.successful(Some(SelfEmploymentIncome(Some(selfEmploymentIncomeId), "2016-17", SelfEmploymentIncomeType.OTHER, BigDecimal("50000.00"))))
}
