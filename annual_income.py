import math

def calculate_salary():
    """计算月薪税后收入和年终奖单独计税的全年到手收入"""
    
    # 用户输入参数
    monthly_salary = 34000  # 月薪（元）
    bonus_months = 3      # 年终奖月数
    housing_fund_rate = 0.12  # 公积金个人缴纳比例
    social_security_base = monthly_salary  # 假设社保基数为月薪
    
    # 社保个人缴纳比例（根据国家标准估算）
    pension_rate = 0.08      # 养老保险
    medical_rate = 0.02      # 医疗保险
    unemployment_rate = 0.005 # 失业保险（部分城市为0.5%）
    
    print("=" * 50)
    print("工资与年终奖税后收入计算器（修正版）")
    print("=" * 50)
    print(f"月薪：{monthly_salary:.2f}元")
    print(f"年终奖月数：{bonus_months}个月")
    print(f"公积金个人缴纳比例：{housing_fund_rate*100}%")
    print(f"社保基数：{social_security_base:.2f}元")
    print("-" * 50)
    
    # 计算五险一金个人缴纳部分
    pension = social_security_base * pension_rate  # 养老保险
    medical = social_security_base * medical_rate  # 医疗保险
    unemployment = social_security_base * unemployment_rate  # 失业保险
    housing_fund = monthly_salary * housing_fund_rate  # 公积金
    
    # 五险一金总计
    total_social_security = pension + medical + unemployment + housing_fund
    
    print(f"养老保险（个人部分8%）：{pension:.2f}元")
    print(f"医疗保险（个人部分2%）：{medical:.2f}元")
    print(f"失业保险（个人部分0.5%）：{unemployment:.2f}元")
    print(f"住房公积金（个人部分10%）：{housing_fund:.2f}元")
    print(f"每月五险一金个人缴纳总计：{total_social_security:.2f}元")
    print("-" * 50)
    
    # 年度综合所得税率表（用于累计预扣法计算）
    # 格式：(下限, 上限, 税率, 速算扣除数)
    annual_tax_brackets = [
        (0, 36000, 0.03, 0),
        (36000, 144000, 0.10, 2520),
        (144000, 300000, 0.20, 16920),
        (300000, 420000, 0.25, 31920),
        (420000, 660000, 0.30, 52920),
        (660000, 960000, 0.35, 85920),
        (960000, math.inf, 0.45, 181920)
    ]
    
    # 年终奖单独计税税率表（月度税率表）
    bonus_tax_brackets = [
        (0, 3000, 0.03, 0),
        (3000, 12000, 0.10, 210),
        (12000, 25000, 0.20, 1410),
        (25000, 35000, 0.25, 2660),
        (35000, 55000, 0.30, 4410),
        (55000, 80000, 0.35, 7160),
        (80000, math.inf, 0.45, 15160)
    ]
    
    # 累计预扣法计算每月个税
    cumulative_taxable_income = 0  # 累计应纳税所得额
    cumulative_tax_paid = 0        # 累计已缴个税
    monthly_take_home = []         # 每月到手收入
    monthly_tax_details = []       # 每月个税明细
    cumulative_income_details = [] # 每月累计应纳税所得额
    
    print("\n每月收入明细（累计预扣法）：")
    print("-" * 50)
    
    # 每月基本扣除（起征点）
    monthly_deduction = 5000
    
    # 计算每个月的税后收入（累计预扣法）
    for month in range(1, 13):
        # 计算本月累计应纳税所得额
        # 累计收入 - 累计五险一金 - 累计基本减除费用
        cumulative_taxable_income += monthly_salary - total_social_security - monthly_deduction
        
        # 使用年度税率表计算累计应缴个税
        cumulative_tax_due = 0
        for lower, upper, rate, quick_deduction in annual_tax_brackets:
            if cumulative_taxable_income > lower:
                taxable_in_bracket = min(cumulative_taxable_income, upper) - lower
                if taxable_in_bracket > 0:
                    cumulative_tax_due += taxable_in_bracket * rate
            else:
                break
        
        # 对于年度税率表，使用速算扣除数计算更简单
        # 找到适用的税率
        applicable_rate = 0
        applicable_deduction = 0
        for lower, upper, rate, quick_deduction in annual_tax_brackets:
            if lower <= cumulative_taxable_income <= upper:
                applicable_rate = rate
                applicable_deduction = quick_deduction
                break
            elif cumulative_taxable_income > annual_tax_brackets[-1][1]:
                applicable_rate = annual_tax_brackets[-1][2]
                applicable_deduction = annual_tax_brackets[-1][3]
        
        # 使用速算扣除数计算累计应缴个税
        cumulative_tax_due = cumulative_taxable_income * applicable_rate - applicable_deduction
        if cumulative_tax_due < 0:
            cumulative_tax_due = 0
        
        # 本月应预扣个税 = 累计应缴个税 - 累计已缴个税
        monthly_tax = cumulative_tax_due - cumulative_tax_paid
        cumulative_tax_paid = cumulative_tax_due
        
        # 本月到手收入
        month_take_home = monthly_salary - total_social_security - monthly_tax
        
        monthly_take_home.append(month_take_home)
        monthly_tax_details.append(monthly_tax)
        cumulative_income_details.append(cumulative_taxable_income)
        
        print(f"第{month:2d}个月：")
        print(f"  累计应纳税所得额：{cumulative_taxable_income:10.2f}元")
        print(f"  适用税率：{applicable_rate*100:4.1f}%")
        print(f"  本月预扣个税：{monthly_tax:10.2f}元")
        print(f"  累计已缴个税：{cumulative_tax_paid:10.2f}元")
        print(f"  本月到手收入：{month_take_home:10.2f}元")
    
    print("-" * 50)
    print(f"全年月薪累计到手收入：{sum(monthly_take_home):.2f}元")
    print(f"全年预扣个税总计：{sum(monthly_tax_details):.2f}元")
    
    # 计算年终奖单独计税
    print("\n" + "=" * 30)
    print("年终奖单独计税计算")
    print("=" * 30)
    
    annual_bonus = monthly_salary * bonus_months
    print(f"年终奖总额：{annual_bonus:.2f}元")
    
    # 年终奖单独计税：年终奖/12确定税率
    bonus_per_month = annual_bonus / 12
    
    # 确定适用税率和速算扣除数
    bonus_tax_rate = 0
    quick_deduction = 0
    
    for lower, upper, rate, deduction in bonus_tax_brackets:
        if bonus_per_month > lower and bonus_per_month <= upper:
            bonus_tax_rate = rate
            quick_deduction = deduction
            break
    
    # 计算年终奖个税
    bonus_tax = annual_bonus * bonus_tax_rate - quick_deduction
    bonus_after_tax = annual_bonus - bonus_tax
    
    print(f"年终奖平均每月：{bonus_per_month:.2f}元")
    print(f"适用税率：{bonus_tax_rate*100}%")
    print(f"速算扣除数：{quick_deduction:.2f}元")
    print(f"年终奖个税：{bonus_tax:.2f}元")
    print(f"年终奖税后收入：{bonus_after_tax:.2f}元")
    
    # 全年总收入
    total_annual_income = sum(monthly_take_home) + bonus_after_tax
    total_annual_income_plus_housing_fund = total_annual_income + housing_fund * 12 * 2
    print("\n" + "=" * 50)
    print("全年收入汇总")
    print("=" * 50)
    print(f"月薪：{monthly_salary}元")
    print(f"月薪税后收入总计：{sum(monthly_take_home):.2f}元")
    print(f"年终奖税后收入：{bonus_after_tax:.2f}元")
    print(f"全年税后总收入：{total_annual_income:.2f}元")
    print(f"全年加上公积金收入：{total_annual_income_plus_housing_fund:.2f}元")
    print(f"平均每月税后收入（含年终奖）：{total_annual_income/12:.2f}元")
    print(f"平均每月税后收入（含年终奖公积金）：{total_annual_income_plus_housing_fund/12:.2f}元")
    print("=" * 50)
    
    return {
        "monthly_take_home": monthly_take_home,
        "annual_bonus_after_tax": bonus_after_tax,
        "total_annual_income": total_annual_income
    }

def explain_calculation():
    """解释计算方法"""
    print("\n" + "=" * 60)
    print("计算方法说明")
    print("=" * 60)
    print("1. 累计预扣法计算公式：")
    print("   累计应纳税所得额 = 累计收入 - 累计五险一金 - 累计5000元基本减除费用")
    print("   累计应纳税额 = 累计应纳税所得额 × 税率 - 速算扣除数")
    print("   本月应纳税额 = 累计应纳税额 - 累计已预缴税额")
    print("\n2. 年度综合所得税率表（用于累计预扣法）：")
    print("   不超过36,000元：税率3%，速算扣除数0")
    print("   36,000-144,000元：税率10%，速算扣除数2,520")
    print("   144,000-300,000元：税率20%，速算扣除数16,920")
    print("   300,000-420,000元：税率25%，速算扣除数31,920")
    print("   420,000-660,000元：税率30%，速算扣除数52,920")
    print("   660,000-960,000元：税率35%，速算扣除数85,920")
    print("   超过960,000元：税率45%，速算扣除数181,920")
    print("\n3. 年终奖单独计税：")
    print("   应纳税额 = 年终奖 × 税率 - 速算扣除数")
    print("   税率根据（年终奖 ÷ 12）的金额查找月度税率表确定")
    print("=" * 60)


if __name__ == "__main__":
    # 运行计算
    result = calculate_salary()
    
    # 显示计算方法说明
    # explain_calculation()