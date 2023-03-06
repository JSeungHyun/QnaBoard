package com.example.QnaSoloProject.member.service;

import com.example.QnaSoloProject.member.entity.Member;
import com.example.QnaSoloProject.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member creatMember(Member member){
        verifyExistsEmail(member.getEmail());
        return memberRepository.save(member);
    }

    public Member updateMember(Member member){
        Member findMember = findVerifiedMember(member.getMemberId());
        Optional.ofNullable(member.getMemberId()).ifPresent(Id -> findMember.setMemberId(Id));
        Optional.ofNullable(member.getMemberStatus()).ifPresent(memberStatus -> findMember.setMemberStatus(memberStatus));
        Optional.ofNullable(member.getName()).ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPassword()).ifPresent(pw -> findMember.setPassword(pw));

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId){
        return findVerifiedMember(memberId);
    }

    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }
    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    public Member findVerifiedMember(long memberId){
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() -> new IllegalArgumentException());

        return findMember;
    }
    private void verifyExistsEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if (findMember.isPresent())
            throw new RuntimeException();
    }
}
