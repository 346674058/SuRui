--��Ʒ����
INSERT INTO t_comm_category(ID, CATEGORY_CODE, CATEGORY_NAME, CREATE_TIME, LAST_MODIFIER, LAST_MODIFIED, STATUS) 
    VALUES(1,'0000100001', '�����ײ�', now(), 'ROOT', now(), 0);
INSERT INTO t_comm_category(ID, CATEGORY_CODE, CATEGORY_NAME, CREATE_TIME, LAST_MODIFIER, LAST_MODIFIED, STATUS) 
    VALUES(2,'0000100002', '��ݼ��', now(), 'ROOT', now(), 0);

--��Ӧ��
INSERT INTO t_comm_provider(PROVIDER_CODE, PROVIDER_NAME, PROVIDER_DESCRIBE, CONTACTOR, MOBILE, ADDRESS, CREATE_TIME, LAST_MODIFIER, LAST_MODIFIED, STATUS) 
    VALUES('0000100001', '�ۼ�СԺ', '�ۼ�СԺ����', '����', '13815421625', '�Ͼ�������������·101��', now(), 'ROOT', now(), 0);

--��Ʒ
INSERT INTO t_commidity(COM_ID, COM_NAME, PROVIDER_ID, CATEGORY_ID, COM_DESCRIBE, CREATE_TIME, LAST_MODIFIER, LAST_MODIFIED, STATUS) 
    VALUES('0000100001000010000100001', '������˿�ǽ���', 1, 1, '������˿�ǽ�������', now(), 'ROOT', now(), 0);
INSERT INTO t_commidity(COM_ID, COM_NAME, PROVIDER_ID, CATEGORY_ID, COM_DESCRIBE, CREATE_TIME, LAST_MODIFIER, LAST_MODIFIED, STATUS) 
    VALUES('0000100001000010000100002', '������˿��', 1, 1, '������˿�ҽ���', now(), 'ROOT', now(), 0);
GO

