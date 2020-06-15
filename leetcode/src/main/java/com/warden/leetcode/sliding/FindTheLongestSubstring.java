package com.warden.leetcode.sliding;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;

/**
 * 元音字母是偶数最长子串
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/20
 */
public class FindTheLongestSubstring {

	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><service><sys-header><data name=\"SYS_HEAD\"><struct><data name=\"RET\"><array><struct><data name=\"RET_MSG\"><field length=\"7\" scale=\"0\" type=\"string\">Success</field></data><data name=\"RET_CODE\"><field length=\"6\" scale=\"0\" type=\"string\">000000</field></data></struct></array></data><data name=\"MESSAGE_TYPE\"><field length=\"4\" scale=\"0\" type=\"string\">1410</field></data><data name=\"TRAN_TIMESTAMP\"><field length=\"9\" scale=\"0\" type=\"string\">225835773</field></data><data name=\"SOURCE_BRANCH_NO\"><field length=\"4\" scale=\"0\" type=\"string\">2400</field></data><data name=\"BRANCH_ID\"><field length=\"6\" scale=\"0\" type=\"string\">351001</field></data><data name=\"MESSAGE_CODE\"><field length=\"4\" scale=\"0\" type=\"string\">0513</field></data><data name=\"RET_STATUS\"><field length=\"1\" scale=\"0\" type=\"string\">S</field></data><data name=\"SERVICE_CODE\"><field length=\"11\" scale=\"0\" type=\"string\">SVR_INQUIRY</field></data><data name=\"DEST_BRANCH_NO\"><field length=\"4\" scale=\"0\" type=\"string\">3000</field></data><data name=\"TRAN_DATE\"><field length=\"8\" scale=\"0\" type=\"string\">20191020</field></data><data name=\"SEQ_NO\"><field length=\"16\" scale=\"0\" type=\"string\">2009102457694799</field></data></struct></data></sys-header><app-header><data name=\"APP_HEAD\"><struct><data name=\"PAGE_END\"><field length=\"1\" scale=\"0\" type=\"string\">0</field></data><data name=\"CURRENT_NUM\"><field length=\"1\" scale=\"0\" type=\"string\">0</field></data><data name=\"PGUP_OR_PGDN\"><field length=\"1\" scale=\"0\" type=\"string\">1</field></data><data name=\"PAGE_START\"><field length=\"1\" scale=\"0\" type=\"string\">0</field></data><data name=\"TOTAL_NUM\"><field length=\"2\" scale=\"0\" type=\"string\">50</field></data></struct></data></app-header><local-header><data name=\"LOCAL_HEAD\"><struct/></data></local-header><body><data name=\"BAT_ARRAY\"><array><struct><data name=\"SOURCE_TYPE\"><field length=\"1\" scale=\"0\" type=\"string\">Z</field></data><data name=\"MEMO2\"><field length=\"8\" scale=\"0\" type=\"string\">开户6个月无交易</field></data><data name=\"LEDGER_BAL\"><field length=\"1\" scale=\"0\" type=\"string\"></field></data><data name=\"TRAN_TIMESTAMP\"><field length=\"8\" scale=\"0\" type=\"string\">20200423</field></data><data name=\"STANDBY2\"><field length=\"8\" scale=\"0\" type=\"string\">开户6个月无交易</field></data><data name=\"STANDBY1\"><field length=\"6\" scale=\"0\" type=\"string\">000000</field></data><data name=\"ACCT_NO\"><field length=\"19\" scale=\"0\" type=\"string\">6231791835101196985</field></data><data name=\"SEX\"><field length=\"1\" scale=\"0\" type=\"string\">F</field></data><data name=\"TEL_NO\"><field length=\"11\" scale=\"0\" type=\"string\">18867567585</field></data><data name=\"DX_TYPE\"><field length=\"3\" scale=\"0\" type=\"string\">106</field></data><data name=\"MEMO1\"><field length=\"4\" scale=\"0\" type=\"string\">6985</field></data><data name=\"ACCT_DESC\"><field length=\"3\" scale=\"0\" type=\"string\">聂云庆</field></data></struct></array></data></body></service>";
		byte[] bytes = xml.getBytes(Charset.forName("utf-8"));
		System.out.println(bytes.length);

	}

	public int findTheLongestSubstring(String s) {
		int n = s.length();
		int[] pos = new int[1 << 5];
		Arrays.fill(pos, -1);
		int ans = 0, status = 0;
		pos[0] = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == 'a') {
				status ^= 1;
			} else if (ch == 'e') {
				status ^= (1 << 1);
			} else if (ch == 'i') {
				status ^= (1 << 2);
			} else if (ch == 'o') {
				status ^= (1 << 3);
			} else if (ch == 'u') {
				status ^= (1 << 4);
			}
			if (pos[status] >= 0) {
				//获取相同状态的位置，取从i往前符号要求的长度
				ans = Math.max(ans, i + 1 - pos[status]);
			} else {
				pos[status] = i + 1;
			}
		}
		return ans;
	}

}
